# JVM 이란 무엇인가 ?

**Java Virtual Machine** 의 약자로, 자바 가상 머신의 약자를 따서 줄여 부르는 용어이다. <br>
JVM 역할은 **자바 어플리케이션을 클래스 로더를 통해 읽어 들여 자바 API 와 함께 실행하는 것**이다. <br>
그리고 JAVA 와 OS 사이에서 중개자 역할을 수행하여, JAVA 가 OS에 구애받지 않고, 재사용을 가능하게 한다. <br>
그리고 가장 중요한 **메모리관리(Garbage Collector)** 를 수행한다. <br>
그리고 JVM은 스택기반의 가상머신이다. ARM 아키텍쳐 같은 하드웨어는 레지스터 기반으로 동작하는데 비해 JVM은 스택기반으로 동작한다.

# 컴파일 하는 방법 ?

Javac 라는 자바-컴파일러를 통해, **.java** 파일을 **.class** file 로 바꿔준다. <br>
우리가 생성할때는 .java 파일로 생성하므로, Hello.java 를 만들고 실습해보자! <br>

```shell script
javac Hello.java
```

![javac 실행](./Image/BeforeCompile.png)

위의 명령어를 실행하고 나면 아래와 같이 .class 파일이 생기는 걸 볼 수 있다.

![javac 실행 후](./Image/AfterCompile.png)

![java 바이트 코드](./Image/JavaByteCode.png)

열어보면 위와 같이 알수 없는 문자들로 가득하다. 즉 **자바-바이트 코드**로 변환되어 있는 것이다. <br>
그렇다면 컴파일러는 왜 런타임전에 이런작업을 해주는 걸까? 컴파일러 과정에서 어떤걸 하이는지 알아보자!

## Javac 가 하는 일들

Class를 동적으로 링킹 정보를 보여준다. 예를 들면 System.out.println 도 보면 , System 이라는 클래스의 member 변수 out 객체의 static method 인
println이라는 메소드를 불러오는 것이다. 그렇다면 System 은 어느곳에 있는 클래스 인가? 라는걸 JVM 이 알아야 런타임 환경에서 ClassLoader 등등이 링킹과정을 
거칠 수 있기 때문에, Javac 를 통해 JVM이 인식할 수 있는 언어로 탈 바꿈 해준다고 생각하면 된다.
<br>
그럼 우리가 javac 의 명령어를 통해 클래스가 어떻게 링크 되는지 알아보자

```shell script
javac -verbose Hello.class
```

![javac Link](./Image/ClassLinkCompile.png)

그럼 System.class 에 대한 연결 외에도 여러 연결들이 많듯, 해당 Class 정보를 알수 있음을 알것이다. <br>
자 지금와서 다시 아까의 자바 ByteCode 를 한번 살펴보자. 자이제 System 대신에 java/lang/System 이라고 써있지 않은가? <br>
그것이 클래스 로더에서 해당 파일을 참조하여 연결 할 수 있도록 javac 가 JVM 이 인식할 수 있도록 바꿔줬음을 알 수 있다. <br>
<br>

그래서 가끔 Spring 을 javac 로 컴파일 시키면 나는 오류들에 대해서도 이제 알 수 있을 것이다. <br>
해당 클래스에 대한 정보가 class 파일에 안적혀있는 것일 확률이 높으므로, **-classpath** 옵션을 통해 외부 라이브러리들을 지정해 주도록 하자! 

# 실행하는 방법 ?

# 바이트 코드란 무엇인가 ?

# JIT 컴파일러란 무엇이며 어떻게 동작하는지 ?

# JVM 구성요소

# JDK 와 JRE 구성요소 

