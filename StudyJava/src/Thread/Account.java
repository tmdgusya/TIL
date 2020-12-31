package Thread;

public class Account {

    private int account; // 계좌

    private String username;

    public Account(int account, String username) {
        this.account = account;
        this.username = username;
    }

    public void deposit(int money) {
        String msg = String.format("%s 님이 %d 만큼 입금하셨습니다.", username, money);
        System.out.println(msg);
        account += money;
        System.out.println("남은 계좌는 : " + account);
    }

    public void withDraw(int money) {
        if (account - money > 0) {
            String msg = String.format("%s 님이 %d 만큼 출금하셨습니다.", username, money);
            System.out.println(msg);
            this.account -= money;
            System.out.println("남은 계좌는 : " + account);
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }
}
