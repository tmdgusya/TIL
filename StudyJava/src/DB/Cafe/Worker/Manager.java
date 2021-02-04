package DB.Cafe.Worker;

import DB.Cafe.Info.DashBoard;
import DB.Cafe.Info.Order;
import DB.Cafe.Util.Logger;
import DB.Cafe.Util.WorkerQueue;
import rx.Observable;
import rx.Observer;
import rx.schedulers.Schedulers;

import java.util.Queue;

public class Manager {

    final Queue<Order> workQueue;
    final WorkerQueue workerQueue;
    final DashBoard dashBoard;

    private final Observer<String> observer = new Observer<String>() {
        private String work;
        @Override
        public void onCompleted() {
            Logger.logging(dashBoard.toString());
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onNext(String workingDoneCoffee) {
            dashBoard.update(workingDoneCoffee);
        }
    };

    public Manager(Queue<Order> workQueue, WorkerQueue workerQueue, DashBoard dashBoard) {
        this.workQueue = workQueue;
        this.workerQueue = workerQueue;
        this.dashBoard = dashBoard;
    }

    public void start() throws InterruptedException {
        while(true){
            Thread.sleep(1000);
            Logger.logging("바리스타 탐색중");
            if(!workQueue.isEmpty()){
                Barista existRestingWorker = workerQueue.isExistRestingWorker();
                if(existRestingWorker == null){
                    Logger.logging("모든 바리스타들이 작업중입니다.");
                    continue;
                }
                if(!workQueue.isEmpty()){
                    Observable<String> stringObservable = existRestingWorker.asyncWork(workQueue.poll());
                    stringObservable.subscribeOn(Schedulers.io()).subscribe(observer);
                }
            }
        }
    }

}
