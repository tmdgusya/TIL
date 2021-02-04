package DB.Cafe.Core;

import DB.Cafe.Coffee.Coffee;
import DB.Cafe.Coffee.Menu;
import DB.Cafe.Info.DashBoard;
import DB.Cafe.Info.Order;
import DB.Cafe.Util.Logger;
import DB.Cafe.Util.WorkerQueue;
import DB.Cafe.Worker.Barista;
import DB.Cafe.Worker.Cashier;
import DB.Cafe.Worker.Manager;

import java.util.LinkedList;
import java.util.Queue;

public class Config {
    //메뉴 3개 바리스타 2
    private final int BARISTA_COUNT = 3;
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
        addBarista();
        return workerQueue;
    }

    private void addBarista() {
        Logger.logging("바리스타는 총 " + BARISTA_COUNT + " 명 입니다.");
        for(int i = 0; i<BARISTA_COUNT; i++){
            workerQueue.add(new Barista(i));
        }
    }

    private DashBoard dashBoard(){
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
        Logger.logging(menu.toString());
        return menu;
    }

}
