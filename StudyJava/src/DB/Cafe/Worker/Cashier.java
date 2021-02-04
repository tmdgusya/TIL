package DB.Cafe.Worker;

import DB.Cafe.Coffee.Coffee;
import DB.Cafe.Info.DashBoard;
import DB.Cafe.Info.Order;

import java.util.Queue;

public class Cashier {

    final Queue<Order> workQueue;
    final DashBoard dashBoard;

    public Cashier(Queue<Order> workQueue, DashBoard dashBoard) {
        this.dashBoard = dashBoard;
        this.workQueue = workQueue;
    }

    public void addOrder(Coffee coffee, int count){
        workQueue.add(new Order(coffee, count));
        dashBoard.add(new String(coffee.getName()));
    }
}
