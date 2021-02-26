# 인스턴스화를 막으려거든 private 생성자를 사용하라

음 이건 아까 싱글톤에서 나왔던 패턴이므로 간단히 짚고 넘어가겠다 :)

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

여기서 private DB(){} 로 선언해줬듯이, 외부에서 인스턴스화를 시키지 못하도록 막아둔것이다!.