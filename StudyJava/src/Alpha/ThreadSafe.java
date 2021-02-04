package Alpha;

import java.util.stream.IntStream;

public class ThreadSafe {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            IntStream.rangeClosed(1,100).forEach(Mission2::whatNumberTheory);
        });
        Thread thread2 = new Thread(()->{
            IntStream.rangeClosed(1,100).forEach(Mission2::whatNumberTheory);
        });

        thread1.start();
        thread2.start();
    }
}
