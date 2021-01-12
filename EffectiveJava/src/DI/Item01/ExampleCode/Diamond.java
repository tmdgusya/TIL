package DI.Item01.ExampleCode;

public class Diamond extends Grade{

    public Diamond(String username, int amount) {
        super(amount, username, Level.DIAMOND.name());
    };
}
