package Thread2.ProcessManager;

import Thread2.Process;

public interface ProcessManager {

    public void addWork(Process process) throws InterruptedException;

    public boolean killProcess(Process process);

    public void start() throws InterruptedException;

    public boolean isExistProcess();
}
