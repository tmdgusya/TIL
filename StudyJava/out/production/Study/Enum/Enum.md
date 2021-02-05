# ENUM 정리하기

## 서론

오늘 코드스쿼드 과정 중에 팀원중 이노가 Enum 에 대한 설명을 팀원들에게 해줄 수 있냐고 물어봐서, 자바 이펙티브 관련해서 공부하다가 알게 된 내용을 알려주다가
나 자신도 스스로 음 그렇게 명확하게 말할 정도로 까지는 정리가 되어 있지 않구나? 라는 생각이 들었다.
그래서 이참에 한번 ENUM 을 정리해 보고 글로 남겨보면서 생각을 정리해야 겠다는 생각을 했다.

## 등장 배경

기술을 이해하려면 일단 등장 배경에 대해서 알아야 한다고 생각한다. 그러니 ENUM 이 왜 등장 했는지를 알아보도록 하자.

옛날 ENUM 이 등장하기전 자바는 정수 열거패턴을 아래와 같이 사용했다고 한다.

```java
private final int KR_APPLE = 1;
private final int KR_BANANA = 2;
private final int AM_APPLE = 3;
private final int AM_BANANA = 4;
```
위의 방식은 관리하기도 불편했을 뿐더러 가독성이 매우 떨어지는 패턴이였다.

그리고 가장 큰 단점은 만약에 우리가 위의 열거 패턴으로, 어디나라의 사과인지를 알고 싶은것인데 만약 `private final int AM_APPLE = 3;` 이
`private final int AM_APPLE = 1;` 로 바뀌게 된다면, `KR_APPLE` 과 같은 것으로 인식하게 되어 관리하기가 힘들어 진다는 단점이 있다.
또한 정수 열거 그룹에 속한 모든 상수를 순회하는 방법또한 마땅치가 않았다.

### ENUM 의 등장

위의 문제들을 해결하기 위해 Enum 이라는 열거형 자료구조가 등장했다.

Enum 에서는 만약 KR_APPLE 이 AM_APPLE 과 독자적으로 구별될 수 있도록 해야했다. 

우리가 보통 독자적인 키를 가질때는 객체를 많이 이용한다. 그래서 Enum 도 똑같이 유일 개체(SingleTon Pattern) 으로 생성하는 것으로 만든다.

```java
class Fruit {
    enum KR {APPLE, BANANA};
    enum AM {APPLE, BANANA};
}
```
위 처럼 선언하고 사용할 수 있으며 해당 객체를 사용하는 클래스에서는 아래와 같이 사용할 수 있다.

ENUM 은 기본적으로 순서를 지정되어 있다. 왼쪽에서 부터 오른쪽으로 0..1 의 오름차순으로 숫자를 배정받게 되는데 이를 확인하는 방법은
`oridnal()` 메소드를 이용하면 된다.
만약 우리가 APPLE 이라는 값을 받아오고 싶다면, `name()` 메소드를 이용해도 된다.
```java
class Main{
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        System.out.println(Fruit.KR.APPLE.ordinal());
        System.out.println(Fruit.KR.APPLE.name());
        System.out.println(Fruit.AM.APPLE.ordinal());
        System.out.println(Fruit.AM.APPLE.name());
    }
}
```
자 위의 결과를 도출해보면 [0, APPLE] | [0, APPLE] 로 같은 결과가 나올 것이다. 
그렇다면 위의 정수 열거형 패턴처럼 구분되는것이 힘들까? 라는 생각이 들 수도 있으니 둘이 같은지를 비교해보자!
```java
        System.out.println(Fruit.AM.APPLE == Fruit.AM.BANANA);
        System.out.println(Fruit.KR.APPLE == Fruit.AM.APPLE);
        
        Fruit.AM APPLE = Fruit.AM.APPLE;
        Fruit.AM APPLE2 = Fruit.AM.APPLE;

        System.out.println(APPLE == APPLE2);
```
1. False
2. 컴파일 오류
3. true

자 이게 어떤 일인지를 생각해보면 그니까 Enum 이란게 지금 타입을 가지고 있기에 컴파일 단계에서 오류가 검출되는 것임을 알 수 있다.

AM.APPLE 은 AM 이라는 타입을 가지고 있고, 그 안에서 APPLE 이라는 하나의 밸류를 가지고 있다. 
아마 그값은 인스턴스 객체 형태의 값일것이다. 그니까 APPLE 이란것이 주소값 상의 어떠한 영역을 차지하고 있을 것이고,
그것은 싱글톤으로 아마 생성될것이다.

## ENUM 도 하나의 클래스 처럼 메소드 사용이 가능하다

아래는 자바의 정석 Enum 부분 예시 코드인데, Enum 에 특정 상태값을 주입시키는 것이 가능하다.

```java
public enum Direction {
    EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH9(4,"^");

    private static final Direction[] DIR_ARR = Direction.values();

    private final int value;
    private final String symbol;

    Direction(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Direction of(int dir){
        if(dir < 1 || dir > 4){
            throw new IllegalArgumentException("Invalid Value : " + dir);
        }
        return DIR_ARR[dir - 1];
    }

    public Direction rotate(int num){
        num = num % 4;

        if(num < 0) num += 4;

        return DIR_ARR[(value-1+num) % 4];
    }

    public String toString(){
        return name()+getSymbol();
    }
}

```

위의 Direction 들은 특정 값을 지닐 수 있으며, 그것들을 Enum 내의 메소드를 통해서 계산하거나 이용할 수 있다.

위의 식은 간단하게 아래 예제에서 테스트 가능하다.

```java

```