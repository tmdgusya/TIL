package Week3Thread.ProcessManager;

import Week3Thread.Process;

public interface ProcessManager {

    public void addWork(Process process) throws InterruptedException;

    public boolean killProcess(Process process);

    public void start() throws InterruptedException;

    public boolean isExistProcess();
}
