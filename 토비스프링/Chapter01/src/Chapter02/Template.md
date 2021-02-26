# 서론

예전에 회사에서 Backend 환경을 구성할때도, DB Connection 이 정상적으로 종료되지않아, Connection Pool 이 초과되어서
생기는 오류들이 있었다. 그때는 TypeORM 자체의 Default Connection 을 줄이고, 최대한 Connection 을 정상적으로 종료해주도록 했는데,
지금 스프링책을 보다보니, 이에관한 내용이 있어 상세하게 정리해보려고 한다.

## DB Connection Pool 안전하게 종료

우리가 이전에 쓰던 코드들에는 닫는부분 이전에서 예외가 일어날 시 Close 가 안될수도 있다.
따라서 우리는 예외처리를 해주어야 하는데

```java
try{
	c = dataSource.getConnection();
	ps = c.prepareStatement("DELETE FROM USER");
	ps.excuteUpdate();
}catch(Exception e){
	throw e;
}finally{
	if(ps != null){
		try{
			ps.close;
		}catch (SQLException e){
			e.printStack~
		}
	}
	if(c != null){
		try{
			c.close():
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
```

이제 예외상황에서도 안전한 코드가 됬다. finally 는 try 블록에서 예외가 발생해도 수행되는 구문이므로 안전하게 close 된다.
우리가 DB Connection 을 종료해줄때는 안전하게 종료되어야 된다는 사실을 여기서 또 와닿으며 배우게 된다.
조회의 경우에는 ResultSet 을 위와 같이 처리해주면 된다. 이로써 우리는 안전하게 종료를 유도해낼 수 있게됬다. 이정도면 실전에 적용가능한 코드라고 한다.

## JDBC try/catch/finally 코드의 문제점

우리가 짠 코드도 완성도가 높은 코드이지만, 이런 코드를 보면 한숨부터 나온다..
조금 더 깔끔하게 적을 수 없을까? 이런 코드들은 컴파일에서 오류를 잡을 수도 없다.
우리가 만약 실수로 try..catch 를 잘못적는다면, 해당 함수에서 DB 객체를 반환하지 않을수도 있다.
지금와서 보니 우리 회사에서 있었던 문제도 이상황과 같다. 그때는 내가 인턴시절로가서 잘 몰랐지만, 최대한 TypeORM 을 이용해 Connection Pool 을 조정하려고했다.
회사사람들은 경험하지 못하던 문제가 발생하니, 정확한 이유를 모르는듯 했다?
우리의 TEST Code 에서 제대로된 객체 반환이 없어서 생긴 문제 같다. 객체 반환을 오류가 있어도 하게끔 했다면, 이러한 문제는 없지 않았을까?
아까의 그 코드를 다시한번 고쳐보자!!

```java
try{
	c = dataSource.getConnection();
	ps = makeStatement(c);
	ps.excuteUpdate();
}catch(SQLException e){
	...
```

private PreparedStatement = makeStatement(Connection c) throws SQLException {
	PreparedStatement ps;
	ps = c.prepareStatement("DELETE FROM USER");
	return ps;
}

# Strategy Pattern

전략 패턴은 개방 폐쇄 원칙을 잘 지키면서도 템플릿 메소드 패턴보다 유연하고 확장성이 뛰어나다. <br>
오브젝트를 아예 둘로 분리하고 클래스 레벨에서는 인터페이스를 통해서만 의존하도록 만드는 전략 패턴이다. <br>
전략 패턴은 OCP 관점에 보면 확장에 해당하는 변하는 부분을 별도의 클래스로 만들어 추상화된 인터페이스를 통해 위임하는 방식이다. <br>
즉 우리가 아까보았던 변하지 않는 부분들, Connection 을 가져오고, 쿼리를 업데이트 한후 Close 해주는 과정들은 무조건 일어나야할 과정들이다 <br>
따라서 해당 부분들을 따로 꺼내어 관리하려고 한다. <br>






