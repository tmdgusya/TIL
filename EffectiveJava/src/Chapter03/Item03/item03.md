# [Item 03] Private 생성자나 열거 타입으로 싱글턴임을 보증하라.

싱글턴이란 인스턴스를 오직 하나만 생성할 수 있는 클래스를 말합니다. <br>
싱글턴의 전형적인 예로는 함수와 같은 무상태 객체나 설계상 유일해야 하는 시스템 컴포넌트를 들수 있습니다. <br>
우리가 싱글로 필요한것들 중 대표적인 예시는 **DB 객체** 라고 볼 수 있다. <br>
객체를 여러개 생성한다면, 그만큼의 Connection Pool 을 유지해야 하기에, 좋지 않고 작업의 보장도 되지않는다 <br>
싱글턴을 만드는 방식은 보통 둘중 하나인데, 첫번째 방식이 아래코드이다. <br>

```java
public class DB {
    
    public static final DB INSTANCE = new DB();
    
    private DB(){}
}
```

이렇게 생성하면, 위와 같이 DB 가 생성될때 객체가 생성되고, 그 이후에 **DB.INSTANCE** 를 통해 이용할 수 있게된다. <br>
예외는 단 한가지, 구너한이 있는 클라이언트는 리플렉션 API AccessibleObject.setAccessible 을 사용해 생성자를 호출할 수 있다. <br>
이런 공격을 방어하려면, 생성자를 수정하여 두번째 객체가 생성되려할때를 방지하면 된다. <br>

```java
public class DB {

    public static final DB INSTANCE = new DB();

    private DB(){}
    
    public static DB getInstance(){return INSTANCE;}
}
```

근데 이러한 방식도, 멀티 스레드를 이용하여, 스레드별로 다른 인스턴스를 넘겨주게 할 수 있다. <br>
뭐 그래서 단순히 Synchronized 를 붙일 수도 있지만, 헤당 방식은 동기화에 대한 오버헤드가 심해질 수 있다고 생각된다. <br>

```java

public class Singleton {
  private volatile static Singleton instance;
  private Singeton() {}
  
  public static Singleton getInstance() {
    if (instance == null)  {
        synchronized(Singleton.class) {
          if (instance == null) {
              instance == new Singleton();  
          }
        }
    }
    
    return instance;
  }
}
```
얼핏보기에는 정말 안전한 코드이다. 만약 객체가 없다면 생성하고, 있다면 기존껄 반환하는 코드이다 ! <br>
위의 코드를 보자 브로큰 이디엄인데.. 왜 브로큰이냐면 우리가 Thread A 와 Thread B 가 있다고 가정해보자 <br>
Thread A 가 객체를 생성하기도 전에 Thread B 도 병렬적으로 작용하여 객체를 생성했다고 해보자 <br>
그럼 둘이 다른 인스턴스를 가지게된다.. 이러한 예외사항은 극히 드물겠지만, 분명 오류를 범할 수 있는 코드이다 <br>
그래서 최근 도입된 LazyHolder 방식의 SingleTon 방식을 구현해보려고 한다. <br>

```java
public class DB {
    
    private DB(){}
    public static DB getInstance(){
        return LazyHolder.INSTANCE;
    }
    
    public static class LazyHolder {
        private static final DB INSTANCE = new DB();
    }
}
```

이것에 대해 설명하자면, DB class 자체에는 LazyHolder 클래스의 변수가 없기때문에, DB 로딩시 LazyHolder 를 초기화하지 않는다. <br>
LazyHolder.INSTANCE 를 호출하는 순간 초기화 되며, **Class 를 로딩하고 초기화 하는 시점은 Thread-safe** 를 보장하기 때문에 <br>
Volatile 이나 synchronized 가 없어도, Thread 에 안전하며 동기화에 대한 오버헤드도 없는 것이다.

**앞으로 싱글톤 패턴을 이용한다면 LazyHolder** 를 이용하자