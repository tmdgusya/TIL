package DB.Cafe.Coffee;

public class Coffee {

    private String Name;
    private int productionTime;
    private int price;

    public Coffee(String name, int productionTime, int price) {
        Name = name;
        this.productionTime = productionTime;
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
