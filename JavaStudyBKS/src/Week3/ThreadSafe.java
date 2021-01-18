package Week3;

import java.util.stream.IntStream;

public class ThreadSafe {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            IntStream.rangeClosed(1,100).forEach(ele -> Mission2.whatNumberTheory(ele));
        });
        Thread thread2 = new Thread(()->{
            IntStream.rangeClosed(1,100).forEach(ele -> Mission2.whatNumberTheory(ele));
        });

        thread1.start();
        thread2.start();
    }
}
