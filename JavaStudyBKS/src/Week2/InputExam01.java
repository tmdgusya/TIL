package Week2;

import java.io.*;
import java.util.Scanner;

public class InputExam01 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        int sum = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        for(int i = 0; i < 1000000; i++){
            sum += 100;
            bw.write( s );
        }
        long endTime = System.currentTimeMillis();
        System.out.println(startTime-endTime);
        br.close();
        bw.close();
    }
}
