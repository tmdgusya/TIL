# 불필요한 객체 생성을 피하라

뭐 일단 설명보다 오늘 배운점을 조금 적어보려고한다. <br>
오늘 스터디중에 pyro 가 String 의 API 에 대해서 설명해줬는데, 그중 valueOf 랑 parseInt 이 기억에 남는다 <br>
아래와 같이 테스트를 위해 적어보았다.
```java
 Integer s = Integer.valueOf("10");
        Integer d = Integer.valueOf("10");
        Integer f = Integer.valueOf("10");
        Integer g = Integer.valueOf("10");
        Integer h = Integer.valueOf("10");
        Integer k = Integer.parseInt("10");
        Integer z =  Integer.parseInt("10");
        Integer b = new Integer("10");

        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(d));
        System.out.println(System.identityHashCode(f));
        System.out.println(System.identityHashCode(g));
        System.out.println(System.identityHashCode(h));
        System.out.println(System.identityHashCode(k));
        System.out.println(System.identityHashCode(z));
        System.out.println(System.identityHashCode(b));

        System.out.println(s.hashCode());
        System.out.println(d.hashCode());
        System.out.println(f.hashCode());
        System.out.println(g.hashCode());
        System.out.println(h.hashCode());
        System.out.println(k.hashCode());
        System.out.println(z.hashCode());
        System.out.println(b.hashCode());

------ 결과값 ---------

692888807
692888807
692888807
692888807
692888807
692888807
692888807
2001049719
```

우리가 여기서 알수있는점은, new 로 했을때 이제 힙영역에 새로운 객체가 생성되고 b 만 새로운 객체를 참조하고있으며,
나머지 변수들은 기존의 변수들을 참조하고 있다는 것이다. 따라서 우리는 10을 배분해야할때 쓸모없는 new 와 같은 객체를 생성하면 안된다는 뜻이다.
우리가 앞서서 배웠던 대로 Static Method 또한 객체 생성비용을 줄여주는 것중 하나이다. <br>
우리가 만약에 객체와는 관계없이 Math.max 라는 함수만 불러서쓰는데, 굳이 Math 라는 함수를 max 를 쓸때마다 만들어줄 이유가 있을까 ? <br>
우리는 비용에 대해서 생각해야 한다. 객체를 생성해서 메모리 상에 공간을 가지는것도 하나의 비용이다. <br>

그래서 우리는 이러한 비용을 줄이기 위해서 Math 의 max 함수를 static 으로 줄 필요가 있다. 이는 실제로도 그렇게 구현되어 있다. <br>
JVM 에서 static 으로 분류된것은 GC 가 관리하지않는다, 왜냐하면 힙영역이 아닌 Static 영역에 존재하기 때문이다. <br>
그래서 우리는 static 영역또한 생각을 잘해야 하긴하나, 객체 생성비용과 해당영역의 비용을 잘 판단하길 바란다. <br>
