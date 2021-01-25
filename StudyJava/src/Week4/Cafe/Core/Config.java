package Week4.Cafe.Core;

import Week4.Cafe.Coffee.Coffee;
import Week4.Cafe.Coffee.Menu;
import Week4.Cafe.Info.DashBoard;
import Week4.Cafe.Info.Order;
import Week4.Cafe.Util.WorkerQueue;
import Week4.Cafe.Worker.Barista;
import Week4.Cafe.Worker.Cashier;
import Week4.Cafe.Worker.Manager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Config {
    //메뉴 3개 바리스타 2
    WorkerQueue workerQueue = new WorkerQueue();
    Queue<Order> workQueue = new LinkedList<>();
    DashBoard dashBoard = new DashBoard();


    public Queue<Order> workQueue(){
      return workQueue;
    }

    public Cashier getCashier(){
        return new Cashier(workQueue(), dashBoard());
    }

    public Manager getManager(){
        return new Manager(workQueue(), workerQueue(), dashBoard());
    }

    public WorkerQueue workerQueue(){
        workerQueue.add(new Barista());
        workerQueue.add(new Barista());
        return workerQueue;
    }

    public DashBoard dashBoard(){
        return dashBoard;
    }

    public Menu menu(){
        Menu menu = new Menu();
        Coffee americano = new Coffee("아메리카노", 3,2000);
        Coffee cafeLatte = new Coffee("카페라떼",5,5000);
        Coffee frappuccino = new Coffee("프라포치노", 7, 5000);
        menu.addMenu(americano);
        menu.addMenu(cafeLatte);
        menu.addMenu(frappuccino);
        return menu;
    }

}
