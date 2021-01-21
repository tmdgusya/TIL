package Week3Thread.ProcessManager;

import Week3Thread.Process;

public class ProcessManagerCycle {
    private ProcessManager processManager = new RoachProcessManager();
    private boolean ExistProcess = true;

    public ProcessManagerCycle(Process process, Process process2, Process process3) throws InterruptedException {
        processManager.addWork(process);
        processManager.addWork(process2);
        processManager.addWork(process3);
    }

    public void startManaging() throws InterruptedException {
        while(ExistProcess){
            processManager.start();
            ExistProcess = processManager.isExistProcess();
        }
    }



}
