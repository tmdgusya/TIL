package Example02;

public class ChildThread implements Runnable{

    private String name;
    private int account;
    private Account accountObj;

    public ChildThread(String name, int account){
        this.name = name;
        this.account = account;
        accountObj = new Account(account, name);
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i<10; i++){
                accountObj.deposit(10000);
                Thread.sleep(5000);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
