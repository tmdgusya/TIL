package Enum;

public class ExamDirection {
    public static void main(String[] args) {
        for (Direction d : Direction.values()){
            System.out.printf("%s=%d%n%n", d.name(), d.getValue());
        }
        Direction EAST = Direction.EAST;
        Direction IS_EAST = Direction.of(1);

        System.out.println("IS_EAST.name() = " + IS_EAST.name());
        System.out.println("IS_EAST.getValue() = " + IS_EAST.getValue());
        System.out.println("IS_EAST.getSymbol() = " + IS_EAST.getSymbol());

        System.out.println("EAST.name() = " + EAST.name());
        System.out.println("EAST.getValue() = " + EAST.getValue());
        System.out.println("EAST.getSymbol() = " + EAST.getSymbol());

        System.out.print("EAST == IS_EAST : ");
        System.out.println(EAST == IS_EAST);

        System.out.println(Direction.EAST.rotate(3).name());


    }
}
