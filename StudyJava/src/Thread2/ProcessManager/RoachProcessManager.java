package Thread2.ProcessManager;

import Thread2.Process;

import java.util.LinkedList;
import java.util.Queue;

public class RoachProcessManager implements ProcessManager{
    private Queue<Process> workQueue = new LinkedList<>();

    @Override
    public void addWork(Process process) throws InterruptedException {
        workQueue.offer(process);
        process.start();
        process.suspend(); // 대기상태로 진입된다.
    }

    @Override
    public void start() throws InterruptedException {
        if(!workQueue.isEmpty()){
            waitMiliSecond(3);
            Process poll = workQueue.poll();
            poll.resume();
            printThreadState(poll);
            if(!killProcess(poll)){
                poll.suspend();
                workQueue.add(poll);
            }
        }
    }

    @Override
    public boolean killProcess(Process process) {
        if(checkProcess(process)){
            process.stop();
            return true;
        }
        return false;
    }

    private boolean checkProcess(Process poll) {
        if(poll.getUptime() <= poll.getCurTime()){
            return true;
        }
        return false;
    }

    private void waitMiliSecond(int second) throws InterruptedException {
        Thread.sleep(second*100);
    }

    //전체 스레드에 대한 프린트
    private void printProcessInfo() {
        for(Process pc : workQueue){
            printThreadState(pc);
        }
    }

    private void printThreadState(Process process) {
        String threadInfo = process.toString();
        System.out.println(threadInfo);
    }

    public boolean isExistProcess() {
        return !workQueue.isEmpty();
    }
}
