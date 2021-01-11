package Week2;

import java.io.IOException;
import java.util.Scanner;

public class InputExam02 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        for(int i = 0; i < 1000000; i++){
            sum += 100;
            System.out.println(s);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(startTime-endTime);
        scan.close();
    }
}
