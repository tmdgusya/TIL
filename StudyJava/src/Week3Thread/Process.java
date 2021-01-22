package Week3Thread;

import java.io.FileReader;

public class Process extends Thread{

    private int uptime;
    private String name;
    private int curTime = 0;
    private String filePath = "/Users/jeongseunghyeon/Desktop/공부폴더/TIL/StudyJava/src/Week3Thread/FileReaderUtil.java";
    private FileReaderUtil fileReaderUtil = new FileReaderUtil();

    public Process(int uptime, String name) {
        this.uptime = uptime;
        this.name = name;
    }

    private Thread thread = new Thread(()->{
        try {
            for(int i = 0; i<uptime; i++){
                for(int j = 0; j <10000; j++){
                    work();
                }
                curTime++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    //스레드에 일을 시킬려했는데 딱히 요구사항에 없어서 File I/O 작업 테스트할려고 만들어둠
    public void work(){
        fileReaderUtil.readFile(filePath);
    }

    @Override
    public void run() {
        thread.start();
    }

    @Override
    public String toString() {
        return name+"Process(" +thread.getState()+ "), "+ curTime + " / 총 구동시간=" + uptime +"sec";
    }

    public int getUptime() {
        return uptime;
    }

    public int getCurTime() {
        return curTime;
    }
}
