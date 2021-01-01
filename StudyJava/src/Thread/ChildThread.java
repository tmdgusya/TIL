package Thread;

public class ChildThread implements Runnable {

    private String name;
    private int account;
    private Account accountObj;
    private FileReaderUtil fileReaderUtil = new FileReaderUtil();
    private final String testMD = "/Users/jeongseunghyeon/Desktop/공부폴더/TIL/StudyJava/src/Thread/Description02.md";

    public ChildThread(String name, int account) {
        this.name = name;
        this.account = account;
        accountObj = new Account(account, name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                accountObj.deposit(10000);
                for (int j = 0; j < 100000; j++) {
                    fileReaderUtil.readFile(testMD);
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        notify();
    }
}
