package Item01.ExampleCode;

public class GradeFactory {

    private static Silver silver;
    private static Gold gold;
    private static Platinum platinum;
    private static Diamond diamond;

    private GradeFactory() {
    }

    public static Grade getGradeInstance(String username, int amount) {
        if (amount < 200000) {
            silver = new Silver(username, amount);
            return silver;
        } else if (amount < 300000) {
            gold = new Gold(username, amount);
            return gold;
        } else if (amount < 400000){
            platinum = new Platinum(username, amount);
            return platinum;
        } else {
            diamond = new Diamond(username, amount);
            return diamond;
        }
    }
}
