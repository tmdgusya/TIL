# Clean Code?

- 깨끗한 코드들의 특징은 무엇일까? 내가 프로젝트 하면서 느꼈던 것들은, 코드에 대한 기술력도 기술력이지만, 나쁜 코드들에 의해
  후에 기능을 추가하는데 애먹었던 적이 많다. 그래서 깔끔하게 코드를 입력하는 것은 상당히 중요하다는 것을 알게 되었다.

## 특징

- **깨끗한 코드는 단순하고 직접적이다.**
- **깨끗한 코드는 결코 설계자의 의도를 숨기지 않는다.**
- **오히려 명쾌한 추상화와 단순한 제어문으로 가득하다.**
- **논리가 간단해야 버그가 숨어들지 못한다.**
- **한가지의 기능만 명확히 제공한다.**
- **단위 테스트와 인수 테스트가 존재한다.**
- **깨끗한 코드에는 의미있는 이름이 붙는다.**
- **의존성은 최소로! 각 의존성을 명확히!**

## 의도를 분명히 밝혀라.

```java
int d; // 이렇게 나타내기 보다는

int elapsedTimeInDays;
int daysSinceCreation;
```

위의 예제처럼 목적을 명확하게 적어주는 것이 좋다!

```java
public List<int[]> getThem(){
    List<int[]> list1 = new ArrayList<int[]>();
    for(int[] x : theList){
        if(x[0] == 4){
            list1.add(x)
        }
        return list1;
    }
}
```

**이렇게 적혀있는 코드는 보면 무슨 기능을 하는지 알기 어렵다.** <br>

1. theList 에 무엇이 들었는가 ?
2. theList 에서 0 번째 값은 왜 4라는 숫자와 비교하는 가 ?
3. 값 4는 무슨 의미인가 ?
4. 함수가 반환하는 리스트 list1 을 어떻게 사용하는가 ?

만약 지뢰찾기 게임을 만든다고 가정하고 위의 코드를 CleanCode 로 바꿔보자!

```java
public List<int[]> getFlaggedCells(){
    List<int[]> flaggedCells = new ArrayList<int[]>();
    for(int[] cell : gameBoard){
        // cell[STATUS_VALUE] == FLAGGED
        if(cell.isFlagged()){
            flaggedCells.add(cell);
        }
    }
    return flaggedCells;
}
```

## 그릇된 정보를 피하라

- 나름되는 널리 쓰이는 의미가 있는 단어를 다른 의미로 사용하면 안된다. 예를 들면 hp,aix,sco 등등 Unix 에서 사용되는 것들을 다른의미로 써서는 안된다.

## 클래스 이름

- 클래스 이름과 객체 이름은 명사나 명사구가 적당하다. Member, Customer 등등..
- 활동적인 부분이 주가되지 않아야 함. 주가되야 한다면 Util 등으로 붙이는게 좋을것 같다.

```java
private void printGuessStatistics(char candidate, int count){
    String number;
    String verb;
    String pluralModifier;
    if(count == 0){
        number = "no";
        verb = "are";
        pluralModifier = "s";
    }else if(count == 1){
        number = "1";
        verb = "is";
        pluralModifier = "";
    }else{
        number = Interger.toString(count);
        varb = "are";
        pluralModifier = "s";
    }
    String guessMessage = String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
    System.out.println(guessMessage);
}
```

- 일단 위의 함수를 보면 printGuessStatistics 가 지고 있는 역할이 너무 많다. 역할을 하나만 정하도록 해보자

```java
public class GuessStatisticsMessage {
    private String message;
    private String verb;
    private String pluralModifier;

    public String make(char candidate, int count){
        createPluralDependentMessageParts(count);
        return String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
    }

    private void createPluralDependentMessageParts(int count){
        if(count == 0){
            thereAreNoLetters();
        }else if(count == 1){
            thereIsOneLetter();
        }else{
            thereAreManyLetters(count);
        }
    }

    private void thereAreNoLetters(int count){
        this.number = Integer.toString(count);
        this.verb = "are";
        this.pluralModifier = "s";
    }

    private void thereIsOneLetter(){
        number = "1";
        verb = "is";
        pluralModifier = "";
    }

    private void thereAreNoLetters(int count){
        nubmer = Interger.toString(count);
        verb = "are";
        pluralModifier = "";
    }
}
```

깔끔하게 바꾸고 나니 훨씬 더 간결하고 알아보기 쉽게 변했다. 코딩을 잘 모르는 사람이라도 해당 코드를 보면 대충은 아 뭘 주는애구나?
라는 걸 알 수 있을 것이다!!
