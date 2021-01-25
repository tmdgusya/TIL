package Week4.Cafe.Worker;

import Week4.Cafe.Coffee.Coffee;
import Week4.Cafe.Info.DashBoard;
import Week4.Cafe.Info.Order;

import java.util.LinkedList;
import java.util.Queue;

public class Cashier {

    final Queue<Order> workQueue;
    final DashBoard dashBoard;

    public Cashier(Queue<Order> workQueue, DashBoard dashBoard) {
        this.dashBoard = dashBoard;
        this.workQueue = workQueue;
    }

    public void add(Coffee coffee, int count){
        workQueue.add(new Order(coffee, count));
        dashBoard.add(new String(coffee.getName()));
    }
}
