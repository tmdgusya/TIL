# [Item08] - finallizer 와 cleaner 사용을 피하라

자바는 두가지 객체 소멸자를 제공한다. 그 중 finallizer 는 예측할 수 없고, 상황에 따라 위험할 수 있어 일반적으로 불필요하다. 
**finallizer 는 나름의 쓰임새가 있지만, 기본적으로는 사용하지 말아야 한다!** 
그래서 자바는 새로운 버전에서 **cleaner** 를 새로운 대안으로 제시했지만, 역시 해당 방법역시 좋지 않은 방법이다.
둘의 제일 큰 단점은 **예측할 수 없다는 것이다.** <br>

예를 들면, 파일닫기를 finallizer와 cleaner 에게 맡긴다면, 해당 작업들이 언제 실행되게 될지몰라 치명적인 반응을 야기할 수 있다.
즉 우리는 즉시 실행되는 작업들은 절대로 맡길 수가 없게 된다.

finallizer 와 cleaner 가 실행되는 시점은 GC 의 수거 알고리즘에 따라 달렸으며, 우리의 프로그램에 만약 해당 지시자들을 사용하여
프로그램을 진행한다고 했을때, 다른 컴퓨터에서는 오동작을 일으키는 문제를 야기할 수도 있다. 해당 컴퓨터의 사양을 알 수 없고, 우리는 그것에
종속하여 프로그래밍을 짠다는 것은 매우 안좋은 습관이기 때문이다.

뭐 더 읽어보면 Persistence 하게 저장되야 하는 값들에도 사용하면 안된다. 라고 나와있긴한데, 그냥 사용하면 안될것 같다.
너무 종속적인 프로그램이 아닐까? 나중에 실무에서 예시를 보고 정확히 왜 쓰는지 파고든다음에 다시 공부해 봐야겠다.