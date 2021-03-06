# 서론

둘이 섞어서 최대한 설명하려고 하는데, 따로 설명하기엔 너무 같은 내용이 많아서 섞어서 이야기 하려고한다.

## Equals 를 재정의 하는데 지켜줘야 하는 5가지 규칙

1. **== 연산자를 사용해 입력이 자기 자신의 참조인지 확인한다.** 자기 자신이면 true 를 반환한다. 이는 단순한 성능 최적화용으로, 비교 작업이 복잡한 상황일 때 값어치를 할 것이다.
2. **instanceof 연산자로 입력이 올바른 타입인지 확인한다.** 그렇지 않다면 false 를 반환한다. 이때의 올바른 타입은 equals 가 정의된 클래스 인것이 보통이지만, 가끔은 그 클래스가 구현한 특정 인터페이스가 될 수 있다. 어떤 인터페이스는 자신을 구현한 클래스들끼리도 비교할 수 있도록 equals 규약을 수정하기도 한다.
3. **입력을 올바른 타입으로 형변환한다.** 앞서 2번에서 instanceof 검사를 했기 때문에 이 단계는 100% 성공한다.
4. **입력 객체와 자기 자신의 대응되는 '핵심' 필드들이 모두 일치하는지 하나씩 검사한다.** 모든 필드가 일치하면 ture를, 하나라도 다르면 false 를 반환한다. 2단계에서 인터페이스를 사용했다면, 입력의 필드값을 가져올 때도 그 인터페이스의 메서드를 사용해야 한다.
5. **equals 를 재정의할땐 hashcode 도 재정의해야 한다.**

## Eqauls 를 재정의하려거든 hashcode 도 재정의하라

**hashcode 재정의를 잘못했을 때 크게 문제가 되는 조항은 두 번째다. 즉, 논리적으로 같은 객체는 같은 해시코드를 반환해야 한다.**

```java
@Override
public int hashcode(){
	return 42;
}
```

위의 방식대로 hashcode 를 반환하면 큰일난다. hashcode 는 객체마다 다르게 구현해줘야 한다. 이렇게 구현한다면, 해시테이블의 버킷하나에 담겨 원래 수행시간이 O(1)이 였던것이 O(n)으로 된다.

## 다음은 좋은 Hashcode 를 반환하는 방법이다.

1. int 변수 result를 선언한 후 값 c로 초기화된다. 이때 c는 해당 객체의 첫번째 핵심 필드를 단계 2.1 방식으로 계산한 hashcode 이다. (**여기서 핵심필드란 equals 비교에서 사용되는 필드를 말한다**)
2. 해당 객체의 나머지 핵심 필드 f 각각에 대해 다음 작업을 수행한다.
    1. 기본 타입 필드라면, Type.hashcode(f) 를 수행한다. 여기서 Type은 해당 기본 타입의 박싱 클래스 이다.
    2. 참조 타입 필드면서 이 클래스의 equals 메서드가 이 필드의 eqauls 를 재귀적으로 호출해 비교한다면, 이 필드의 hashcode 를 재귀적으로 호출한다. 계산이 복잡해 질것 같으면, 이 필드의 표준형을 만들어 그 표준형의 hashcode 를 호출한다. 필드의 값이 null 이면 0 을 사용한다.
    3. 필드가 배열이라면, 핵심 원소 각각을 별도 필드처럼 다룬다. 이상의 규칙을 재귀적으로 적용해 각 핵심원소의 해시코드를 계산한 다음, 단계 2.b 방식으로 갱신한다.
    4. 단계 2.1 에서 계산한 해시코드 c 로 result 를 갱신한다.

        ```java
        result = 31 * result + c;
        ```

3. result 를 반환한다.