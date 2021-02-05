package Enum;

public enum Direction {
    EAST(1, ">"), SOUTH(2, "V"), WEST(3, "<"), NORTH9(4,"^");

    private static final Direction[] DIR_ARR = Direction.values();

    private final int value;
    private final String symbol;

    Direction(int value, String symbol) {
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Direction of(int dir){
        if(dir < 1 || dir > 4){
            throw new IllegalArgumentException("Invalid Value : " + dir);
        }
        return DIR_ARR[dir - 1];
    }

    public Direction rotate(int num){
        num = num % 4;

        if(num < 0) num += 4;

        return DIR_ARR[(value-1+num) % 4];
    }

    public String toString(){
        return name()+getSymbol();
    }
}
