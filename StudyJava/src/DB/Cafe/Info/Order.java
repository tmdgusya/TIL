package DB.Cafe.Info;

import DB.Cafe.Coffee.Coffee;
import DB.Cafe.Customer;

public class Order {

    Coffee coffee;
    Customer customer;
    int count;

    public Order(Coffee coffee, int count) {
        this.coffee = coffee;
        this.count = count;
    }


    public Coffee getCoffee() {
        return coffee;
    }
}
