package Thread2.ProcessManager;

import Thread2.Process;

public class ProcessControllBlock {

    private int curTime;
    private int upTime;

    public void savePCBData(Process process){
        this.curTime = process.getCurTime();
        this.upTime = process.getUptime();
    }



}

