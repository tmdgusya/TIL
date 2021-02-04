package DB.Cafe.Util;

import DB.Cafe.Worker.Barista;

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
