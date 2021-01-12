package DI.Item01.ExampleCode;

import DI.Item01.ExampleCode.Grade;

public class Platinum extends Grade{

    public Platinum(String username, int amount) {
        super(amount, username, Level.PLATINUM.name());
    };
}
