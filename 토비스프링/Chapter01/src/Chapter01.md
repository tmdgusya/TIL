# Chapter01

대체로 JDBC 를 이용한 예제가 많은데, JPA 를 많이 봐둬서 그런지 읽는데 도움이 되게 많이 됬다. <br>
토비의 스프링은 스프링 뿐만아니라, 왜 객체지향 프로그래밍이 이렇게 설계되었는지, 우리가 코드를 어떻게 짜는게 좋은 방식인지를 리팩토링 전과 후로 나뉘어
잘 설명해준다. 아래 예시를 보면 잘 이해될 것이다.

- **반드시 코드를 따라 해서 직접 타이핑 해 보길바란다. 자신의 실력을 과신하지말고, 직접 입력해라! 남들 눈엔 아직도 배워야 할게 많은 사람일 수 있다.**

일단 User.class 를 기반으로 움직인다.

```java
package BeforeRefactoring;

public class User {
    String id;
    String name;
    String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

```

User Class 를 기준으로 Data 에 Access 하기 위해 만든 UserDao 코드는 아래와 같다.

```java
package BeforeRefactoring;

import java.sql.*;

public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
        String DataBaseURL = "jdbc:h2:~/tobySpring";
        String InsertUserQuery = "INSERT INTO User(id, name, password) values(?,?,?)";

        Connection conn = DriverManager.getConnection(DataBaseURL, "sa", "");

        PreparedStatement ps = conn.prepareStatement(InsertUserQuery);
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        String DataBaseURL = "jdbc:h2:~/tobySpring";
        String getUserQuery = "SELECT * FROM User WHERE id = ?";
        Connection conn = DriverManager.getConnection(DataBaseURL, "sa", "");
        PreparedStatement preparedStatement = conn.prepareStatement(getUserQuery);
        preparedStatement.setString(1, id);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getNString("name"));
        user.setName(rs.getString("password"));

        rs.close();
        preparedStatement.close();
        conn.close();

        return user;
    }

}

```

테스트 해봐도 잘 동작하고, 코드상에도 문제가 없는 것 처럼 보인다. <br>
하지만 데이터베이스 Connection을 얻어오는 부분이 중복되는 것 처럼  <br>
해당 부분을 Factory Method Pattern 으로 다시 짜보자. <br>

```java
package OneTimeRefactor;

import BeforeRefactoring.User;

import java.sql.*;

public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
        String InsertUserQuery = "INSERT INTO User(id, name, password) values(?,?,?)";
        Connection conn = getConnection();

        PreparedStatement ps = conn.prepareStatement(InsertUserQuery);
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        String getUserQuery = "SELECT * FROM User WHERE id = ?";
        Connection conn = getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(getUserQuery);
        preparedStatement.setString(1, id);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getNString("name"));
        user.setName(rs.getString("password"));

        rs.close();
        preparedStatement.close();
        conn.close();

        return user;
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        String DataBaseURL = "jdbc:h2:~/tobySpring";
        Connection conn = DriverManager.getConnection(DataBaseURL, "sa", "");
        return conn;
    }
}

```

위와 같이 코드가 조금 관심사가 분리된것 같지 않은가? <br>
그럼에도 불구하고 아직도 문제가 많다. 만약 우리가 UserDao 라는 파일을 다른 포털에 판다고 생각해보자. <br>
해당 포털은 데이터 베이스 커넥션을 생성하는 과정이 다를 수도 있다. 그래서 해당 포털에서 구현할 수 있도록 설계되는 것이 맞다. <br>
그래서 우리는 추상 클래스를 이용해 볼 것이다 <br>

```java
package TwoTimeRefactor;

import BeforeRefactoring.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDao {

    public void add(User user) throws ClassNotFoundException, SQLException {
        String InsertUserQuery = "INSERT INTO User(id, name, password) values(?,?,?)";
        Connection conn = getConnection();

        PreparedStatement ps = conn.prepareStatement(InsertUserQuery);
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User get(String id) throws SQLException {
        String getUserQuery = "SELECT * FROM User WHERE id = ?";
        Connection conn = getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(getUserQuery);
        preparedStatement.setString(1, id);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getNString("name"));
        user.setName(rs.getString("password"));

        rs.close();
        preparedStatement.close();
        conn.close();

        return user;
    }

    public abstract Connection getConnection() throws SQLException;
}

```

이제 N 사와 D 사는 우리의 UserDao 를 구입하고 나서 사용할때, 아래와 같이 사용하면 된다.
```java
public class DUserDao extends UserDao{
    @Override
    public Connection getConnection() throws SQLException {
        String DataBaseURL = "jdbc:h2:~/DaumDB";
        Connection conn = DriverManager.getConnection(DataBaseURL, "daum", "");
        return conn;
    }
}

public class DUserDao extends UserDao{
    @Override
    public Connection getConnection() throws SQLException {
        String DataBaseURL = "jdbc:h2:~/NaverDB";
        Connection conn = DriverManager.getConnection(DataBaseURL, "naver", "");
        return conn;
    }
}
```

어떤가 조금은 더 확장성이 좋아지지 않았는가? <br>
그럼에도 불구하고 아직도 문제가 남아있다. 우리가 자바를 공부했다면 상속은 그리 좋지 않은 방식이란걸 알게된다. <br>
왜냐하면 이중상속시 다이아몬드 참조 문제가 발생하므로, 우리가 판매하는 입장에서 상속으로 명시하여 판다면, 안되는 회사는 구매하지 않을것이다.. <br>
그래서 우리는 클래스를 슬슬 분리해야 할때가 왔다!! <br>

우리는 Connection은 InterFace로 분리하여 사용할 것이다. Connection의 경우 계속해서 상속받을 수 있고, InterFace 라는 추상적인 하나의 행동으로
정의해야 다중상속시에도 문제가 생기지 않기때문이다. Interface로 설정하고, 해당 포털싸이트에서 구현하게 할것이다.

```java
public interface ConnectionMaker {
    public Connection getConnection() throws SQLException;
}

public class NConnectionMaker implements ConnectionMaker{
    @Override
    public Connection getConnection() throws SQLException {
        String DataBaseURL = "jdbc:h2:~/NaverDB";
        Connection conn = DriverManager.getConnection(DataBaseURL, "Naver", "");
        return conn;
    }
}

public class DConnectionMaker implements ConnectionMaker{
    @Override
    public Connection getConnection() throws SQLException {
        String DataBaseURL = "jdbc:h2:~/DaumDB";
        Connection conn = DriverManager.getConnection(DataBaseURL, "Daum", "");
        return conn;
    }
}
```

```java
public class UserDao{
    
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        String InsertUserQuery = "INSERT INTO User(id, name, password) values(?,?,?)";
        Connection conn = connectionMaker.getConnection();
        PreparedStatement ps = conn.prepareStatement(InsertUserQuery);
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        String getUserQuery = "SELECT * FROM User WHERE id = ?";
        Connection conn = connectionMaker.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(getUserQuery);
        preparedStatement.setString(1, id);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getNString("name"));
        user.setName(rs.getString("password"));

        rs.close();
        preparedStatement.close();
        conn.close();

        return user;
    }
}

```
아까와 비슷하지만, interface로 구현하여 확장성을 높였다는데 의의를 둔다면 정말 괜찮아진 코드이다. <br>
좀 코드가 길어도 양해바란다. 짧게 스킵하고 적으면 진짜 입문자인 사람들은 아예 잘 이해하지 못하므로... <br>

```java

public class MainTest {
    
    ConnectionMaker dConn = new DConnectionMaker();
    ConnectionMaker nConn = new NConnectionMaker();
    
    UserDao dUserDao = new UserDao(dConn);
    UserDao nUserDao = new UserDao(nConn);
}
```
**이렇게 되면 UserDao 는 ConnectionMaker Interface 의 구현 클래스가 어떤 클래스인지 몰라도 된다.** <br>

우리는 드디어 UserDao 관심사 분리에 성공해냈다. UserDao 에 있으면 안되는 관심사항, 책임을 클라이언트에게 떠넘기는 작업을 성공한 것이다 !! <br>
이제 Connection 을 어떻게 바꾸든 UserDao 는 영향을 받지 않는다. 즉, Test 코드로서도 종속적인 탈출을 성공한것이다! <br>
우리가 테스트 코드를 성공적으로 짜기 위해서는 위와 같은 코드로 설계해야한다는 사실도 알 수 있을 것이다. <br>
테스트 코드 상 Connection Maker 와 UserDao 는 이제 다른 역할로서의 테스트 결과로서 테스팅되어진다 <br>

# 원칙과 패턴

## 개방 폐쇄 원칙 (OOP 원칙 중 하나)

- 개방 폐쇄 원칙은 지금 까지 우리가 해온 방식을 깔끔하게 설명할 수 있다. 
- **클래스나 모듈은 확장에는 열려 있어야 하고, 변경에는 닫혀 있어야 한다**
- 우리가 설계한 UserDao 는 DB 연결 방법이라는 기능을 확장하는데는 열려 있다. UserDao 에 DBconnection 이 바뀌더라도, 어떠한 문제가 일어나지 않는다.
따라서 UserDao 는 이러한 변경에도 영향을 받지 않으므로, 변경에는 닫혀있다고 이야기 할 수 있다. 와 진짜 확 와닿게 이해되지 않는가 ?
- 우리가 그럼 돌아가서 처음의 리팩토링 되기전의 Dao 를 보자, DB 연결을 확장하기도 매우 불편하지 않은가?

## 높은 응집도와 낮은 결합도 
- 높은 응집도 낮은 결합도 라는것은, 아마도 정보처리기사 시험이나 기타 소프트웨어 개발론을 많이 본 사람이라면 이해하기 쉬울 것이다. <br>
응집도가 높다는 건 하나의 모듈, 클래스가 하나의 책이 또는 관심사에만 집중되어 있다는 것이다. <br>
불필요하거나 직접 관련이 없는 외부의 관심과 책임이 얽혀 있지 않으며, 하나의 공통 관심사는 한 클래스에 모여 있다. <br>
우리가 원시 UserDao 를 썼다면, DBConnection을 바꾼 이후에 UserDao 에서 바꿔줘야 할 부분은 없는지 찾고, 이것저것 영향이 끼쳤는지
테스트를 돌려봐야 할것이다. 정말 불편하고, 코드가 꼬여있다면 고치기도 힘들것이다. 

- 낮은 결합도 라는 것은 간단하게 "하나의 오브젝트가 변경이 일어날 때 관계를 맺고있는 다른 오브젝트에게 변화를 요구하는 정도가 낮다" 라는 뜻이다.
즉, 우리의 UserDao 오브젝트는 DBConnection 오브젝트가 변경되어도, 변화되는 점이 없다. 따라서 우리는 원시 UserDao 에 비해 결합도가 매우 낮다.
라는 것을 알 수 있다.

## Strategy Pattern

개선한 UserDto 의 구조를 디자인 패턴의 시각으로 보면, 전략 패턴에 해당 된다고 볼 수 있다. 
**전략 패턴은 자신의 기능 Context 에서, 필요에 따라 변경이 필요한 알고리즘을 인터페이스를 통해 외부로 분리시키고, 이를 구현한 구체적인 알고리즘 클래스를
필요에 따라 바꿔서 사용할 수 있게 하는 디자인 패턴이다.**

# 제어의 역전 (Inversion Of Control = IOC)

- 일반적인 프로그램의 제어 흐름 구조가 뒤 바뀌는 것!

- 일반적인 프로그램의 흐름은 main() 메소드와 같이 프로그램이 시작되는 지점에서 다음에 사용할 오브젝트를 결정하고,
결정한 오브젝트를 생성하고, 만들어진 오브젝트에 있는 메소드를 호출하고, 그 오브젝트 메소드 안에서 다음에 사용할 것은 결정하고 식이 반복된다. <br>
이런 프로그램 구조에서 각 오브젝트는 프로그램 흐름을 결정하거나 사용할 오브젝트를 구성하는 작업에 능동적으로 참여한다. <br>
초기 UserDaoTest 는 클래스를 직접 생성하고, 만들어진 오브젝트의 메소드를 사용한다. <br>

UserDao 또한 자신이 사용할 ConnectionMaker 의 구현 클래스를 자신이 직접 생성하고, 만들어진 오브젝트의 메소드를 사용한다. <br>

제어의 역전이란 이런 제어 흐름의 개념을 거꾸로 뒤집는 것이다. <br>
제어의 역전에서는 자신이 사용할 오브젝트를 자신이 스스로 정하지 않는다. 당연히 생성하지도 않는다. <br>
또 자신도 어떻게 만들어지고, 어디서 사용되는지를 알 수 없다 <br>

모든 제어 권한을 자신이 아닌 다른 대상에게 위임하기 때문이다. <br>
와.. 지금까지 IoC 를 와닿게 이해하지 못했는데, 토비의 스프링을 보고 정확히 이해하게 됬다.

```java
public class UserDaoFactory {
    
    public UserDao getDaumUserDao(){
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }

    public UserDao getNaverUserDao(){
        ConnectionMaker connectionMaker = new NConnectionMaker();
        UserDao userDao = new UserDao(connectionMaker);
        return userDao;
    }
}
```

이렇게 분리를 해둔다면 Daum 사에서는 Test 할때, 테스트 팀에서는 객체가 어떻게 초기화 되는지 몰라도된다! <br>
내가 테스트 코드를 짤때, 이런 코드를 많이 짰었는데 그때 팩토리 방식으로 분리를 시켜둘걸 그랬다. 지금이라도 이렇게 분리하자! <br>
**어떻게 만들지와, 어떻게 사용할지도 다른 관심사이다. 그러므로 팩토리를 만드는 것이 맞다** <br>
이말이 잘 이해안간다면, 당신이 테스트 코드 작성자인데, 객체가 어떻게 생성되는지 까지 알아야 하는가? 를 생각하면 된다. <br>

## 분석

- UserDao 와 ConnectionMaker 가 핵심 기술 로직과, 데이터로직을 담당하고 있고, DaoFactory 는 이러한 객체를 구성하여 생성하고,
관계를 정의해주는 책임을 맡고 있다. 우리는 이로서 컴포넌트 역할을 하는 오브젝트와 애플리케이션의 구조를 결정하는 오브젝트를 분리해내는데 성공했다.
근데 만약에 MessageDao 에서도 UserDto 가 필요하다고 해보자. 그렇다면 위의 코드도 분명 문제가 있다. 따라서 아래와 같이 변경해준다.

```java
public class NaverUserDaoFactory {
    public UserDao getNaverUserDao(){
        UserDao userDao = new UserDao(getConnectionMaker());
        return userDao;
    }
    
    public MessageDao getMessageDao(){
        MessageDao msg = new MessageDao(getConnectionMaker());
        return msg;
    }

    private ConnectionMaker getConnectionMaker(){
        ConnectionMaker connectionMaker = new NConnectionMaker();
        return connectionMaker;
    }
}
```

