package Week2;

import javax.swing.plaf.synth.SynthUI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteExam1 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        long endTime;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("src/Week2/ByteExam1.java");
            fos = new FileOutputStream("src/Week2/test.txt");

            int readData = -1;
            while((readData = fis.read()) != -1){
                fos.write(readData);
            }
            endTime = System.currentTimeMillis();
            System.out.println(endTime-startTime);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fos.close();
            fis.close();
        }
    }
}
