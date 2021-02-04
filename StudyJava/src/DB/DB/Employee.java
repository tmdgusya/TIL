package DB.DB;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Employee {

    private PCManager pcManager = new PCManager();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
    private String time = dateFormat.format(new Timestamp(System.currentTimeMillis()));

    public void init(){
        pcManager.getVacantSeats();
    }

    public void stop(int id){
        User user = new User(id);
        user.setEndDate(time);
        final int stopPCID = pcManager.stop(user);
        System.out.println(stopPCID + " 가 종료되었습니다.");
    }

    public void assign(int id){
        final ArrayList<PC> vacantSeats = pcManager.getVacantSeats();
        final PC canUsepc = vacantSeats.get(0);
        User user = new User(id, time);
        pcManager.Assignment(user, canUsepc);
        System.out.println(canUsepc.getPc_id() + " 에 앉습니다.");
    }

    public void print(){
        pcManager.showVancantSeatList();
    }

}
