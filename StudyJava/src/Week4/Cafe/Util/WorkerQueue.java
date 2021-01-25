package Week4.Cafe.Util;

import Week4.Cafe.Info.Order;
import Week4.Cafe.Worker.Barista;

import java.util.LinkedList;
import java.util.Queue;

public class WorkerQueue {

    private final Queue<Barista> workerQueue = new LinkedList<>();

    public void add(Barista barista){
        workerQueue.add(barista);
    }

    public Barista isExistRestingWorker(){
        for(Barista barista : workerQueue){
            if(!barista.isWorking()){
                return barista;
            }
        }
        return null;
    }
}
