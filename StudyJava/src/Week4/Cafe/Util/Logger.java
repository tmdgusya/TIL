package Week4.Cafe.Util;

import java.time.LocalTime;

public class Logger {

    static public void logging(String Message){
        System.out.println("[INFO] " + LocalTime.now() + "  " + Message);
    }

}
