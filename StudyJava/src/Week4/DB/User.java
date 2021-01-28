package Week4.DB;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    private int user_id;
    private String startDate;
    private String endDate;
    private PC pc;

    public User(int user_id) {
        this.user_id = user_id;
    }

    public User(int user_id, String startDate) {
        this.user_id = user_id;
        this.startDate = startDate;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public PC getPc() {
        return pc;
    }

    public void setPc(PC pc) {
        this.pc = pc;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
