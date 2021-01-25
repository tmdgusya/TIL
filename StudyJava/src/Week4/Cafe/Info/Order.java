package Week4.Cafe.Info;

import Week4.Cafe.Coffee.Coffee;
import Week4.Customer;

public class Order {

    Coffee coffee;
    int count;

    public Order(Coffee coffee, int count) {
        this.coffee = coffee;
        this.count = count;
    }


    public Coffee getCoffee() {
        return coffee;
    }
}
