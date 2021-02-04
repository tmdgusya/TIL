package DB.Cafe.Worker;

import DB.Cafe.Coffee.Coffee;
import DB.Cafe.Info.Order;
import DB.Cafe.Util.Logger;
import rx.Observable;

public class Barista {

    private int id;
    boolean isWork = false;

    public Barista(int id) {
        this.id = id;
    }

    public Observable<String> asyncWork(Order order){
        Observable<String> work = Observable.fromCallable(()->{
                try {
                    Logger.logging("Barista"+ id +" "+order.getCoffee().getName() + " 주문을 받았습니다.");
                    work(order);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            return order.getCoffee().getName();
        });
        return work;
    }

    public void work(Order order) throws InterruptedException {
        Coffee coffee = order.getCoffee();
        int productionTime = coffee.getProductionTime();
        isWork = true;
        Thread.sleep(productionTime*1000);
        isWork = false;
    }

    public boolean isWorking(){
        return isWork;
    };

}
