package Week3;

import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        IntStream.rangeClosed(2,100).reduce((a,b) -> {
            Mission2.whatNumberTheory(a);
            return a+1;
        });
    }
}
