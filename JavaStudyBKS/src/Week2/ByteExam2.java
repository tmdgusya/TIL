package Week2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteExam2 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long endTime;
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try{
            fis = new FileInputStream("src/Week2/ByteExam1.java");
            fos = new FileOutputStream("src/Week2/Test2.txt");

            int readCount = -1;
            byte[] buffer = new byte[512];
            while((readCount = fis.read(buffer)) != -1){
                fos.write(buffer, 0, readCount); // buffer 의 0번째부터 읽어들인 바이트의 갯수까지
            }
            endTime = System.currentTimeMillis();
            System.out.println(endTime-startTime);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
