package Chapter03.Item01.ExampleCode;

public class Platinum extends Grade{

    public Platinum(String username, int amount) {
        super(amount, username, Level.PLATINUM.name());
    };
}
