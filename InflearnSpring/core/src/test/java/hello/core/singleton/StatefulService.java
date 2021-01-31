package hello.core.singleton;

public class StatefulService {

    private String name;
    private int price;

    public void order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
