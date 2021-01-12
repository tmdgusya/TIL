package DI.Item01.ExampleCode;

public class Grade {
    private int amount;
    private String username;
    private String grade;

    public Grade(int amount, String username, String grade) {
        this.amount = amount;
        this.username = username;
        this.grade = grade;
    }

    public int getAmount() {
        return amount;
    }

    public String getUsername() {
        return username;
    }

    public String getGrade() {
        return grade;
    }
}
