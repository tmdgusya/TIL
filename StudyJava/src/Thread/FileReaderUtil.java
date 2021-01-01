package Thread;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderUtil {

    public int readFile(String filePath) {
        BufferedReader br = null;
        StringBuffer storeReadLine = new StringBuffer();
        try {
            br = new BufferedReader(new FileReader(filePath));
            String readLine = null;

            while ((readLine = br.readLine()) != null) {
                storeReadLine.append(readLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return storeReadLine.length();
    }
}
