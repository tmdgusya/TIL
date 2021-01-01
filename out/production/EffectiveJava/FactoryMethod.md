# 정적 팩토리 메소드

- 전통적으로 인스턴스를 얻는 수단은 **Public 생성자다.**
- 간단히 이야기하면 좀 어려울 수 있는데, Method 를 Static 으로 설정해 둔것이라고 간단히 이해하고 글을 읽으면서, 아래의 옵션들에 맞게 구성하면 된다.

  - 예시로는 String.valueOf(10) 이라하면 우리는 String 클래스에 valueOf 가 아래와 같이 선언되어 있음을 알 수 있다.
  - 우리는 String class 를 새롭게 선언하지 않고도 아래 함수를 이용할 수 있다.
  - 아마 Overload 로 여러 형태들로 valueOf 가 존재할텐데 일단 정수로 예시를 들겠다.

    ```java
    public static String valueof(int n){
        Integer.toString(n);
    }
    ```

- 오늘 우리가 배울 생성자와 별도로 **정적 팩토리 메소드**에 대해서 알아보자

## 장점

- **이름을 가질 수 있다.**

  - 생성자에 넘기는 매개변수와 생성자 자체만으로는 반환될 객체의 특성을 제대로 설명하지 못한다.
  - 반면 정적 팩터리 메소드는 이름만 잘지으면 반환될 객체의 특성을 쉽게 묘사할 수 있다.

- **호출될 때 마다 인스턴스를 새로 생성하지는 않아도 된다.**

  - 불변 클래스는 인스턴스를 미리 만들어 놓거나, 새로 생성한 인스턴스를 캐싱하여 재활용하는 식으로 불필요한 객체 생성을 피할 수 있다.
  - 반복되는 요청에 같은 객체를 반환하는 식으로, 정적 팩터리 방식의 클래스는 언제 어느 인스턴스를 살아 있게 할지를 철저히 통제 할 수 있다.
  - 인스턴스를 통제하면 싱글턴으로 만들 수도, 인스턴스화 불가로 만들 수도 있다.

- **반환 타입의 하위 타입 객체를 반환할 수 있는 능력이 있다.**

  - 이 능력은 반환할 객체의 클래스를 자유롭게 선택할 수 있게하는 엄청난 유연성을 선물한다.
  - API 를 만들때, 이 유연성을 응용하면 구현 클래스를 공개하지 않고도 그 객체를 반환할 수 있어 API를 작게 유지할 수 있다.
  - 이는 인터페이스를 정적 팩터리 메서드의 반환 타입으로 사용하는 인터페이스 기반 프레임워크를 만드는 핵심 기술이기도 하다.
  - 이 개념이 상당히 이해 안갈수도 있는데 예외 코드로 보여주겠다.

### 반환 타입 예시 코드

만약 우리가 구매 누적 가격에 따라 각기 다른 할인율을 제공해야 한다고 생각해보자. <br>
그럼 우리는 **discount** 메소드가 Overriding 이 되어야 한다는 사실을 깨달을 것이다. <br>
자 그럼 가격에 따른 등급을 아래에 설계해 보자 <br>

```
가격    등급
100000 Silver
200000 Gold
300000 Platinum
400000 Diamond
```

- Grade.class 는 공통적인 속성들을 담았다. Grade 에서 필요한 Method 혹은 필요한 멤버 변수들을 담았다.
- 회원들 스텝 단계는 

```java


package ExampleCode;

public class Grade {
    private int amount;
    private String username;
    private String grade;

    public Grade(int amount, String username, String grade) {
        this.amount = amount;
        this.username = username;
        this.grade = grade;
    }

    public int getAmount() {
        return amount;
    }

    public String getUsername() {
        return username;
    }

    public String getGrade() {
        return grade;
    }
}
```