package Enum;

public class FruitTest {

    public static void main(String[] args) {
        System.out.println(Fruit.KR.APPLE.ordinal());
        System.out.println(Fruit.KR.APPLE.name());
        System.out.println(Fruit.AM.APPLE.ordinal());
        System.out.println(Fruit.AM.APPLE.name());

        System.out.println(Fruit.AM.APPLE == Fruit.AM.BANANA);

        Fruit.AM APPLE = Fruit.AM.APPLE;
        Fruit.AM APPLE2 = Fruit.AM.APPLE;

        System.out.println(APPLE == APPLE2);
    }
}
