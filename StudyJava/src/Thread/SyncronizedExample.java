package Thread;

import java.io.BufferedReader;

public class SyncronizedExample {
    private String mMessage;

    public static void main(String[] agrs) {
        SyncronizedExample tempObj = new SyncronizedExample();
        System.out.println("Test start!");

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                tempObj.callMe("Thread1");
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                tempObj.callMe("Thread2");
            }
        }).start();

        System.out.println("Test end!");
    }

    public synchronized void callMe(String whoCallMe) {
        mMessage = whoCallMe;
        // System.out.println(whoCallMe + " | " + mMessage);
        try {
            long sleep = (long) (Math.random() * 100);
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!mMessage.equals(whoCallMe)) {
            System.out.println(whoCallMe + " | " + mMessage);
        }
    }
}
