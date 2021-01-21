package Week3Thread;

import Week3Thread.ProcessManager.ProcessManagerCycle;

public class OS {

    private static ProcessManagerCycle processManagerCycle;

    public static void init(){
        System.out.println("OS Booting...");
    }

    public static void main(String[] args) throws InterruptedException {
        init();
        System.out.println("Syslog : Init Process Create");
        executeProcess();
        processManagerCycle.startManaging();
        System.out.printf("Process All killed...");
    }

    private static void executeProcess() throws InterruptedException {
        Process Aprocess = new Process(3, "A");
        Process Bprocess = new Process(5, "B");
        Process Cprocess = new Process(7, "C");
        processManagerCycle = new ProcessManagerCycle(Aprocess, Bprocess, Cprocess);
    }
}
