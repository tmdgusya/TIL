package Item50;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Date start = new Date();
        start.setYear(10);
        Date end = new Date();
        end.setYear(11);
        Item50 item50 = new Item50(start, end);
        end.setYear(9);

        Date end1 = item50.getEnd();

        end1.setYear(180);

        Date end2 = item50.getEnd();

        System.out.println(end2.getYear());
    }

}
