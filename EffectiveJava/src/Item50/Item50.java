package Item50;

import java.util.Date;

public class Item50 {

    private final Date start;
    private final Date end;

    /**
     * @Param start 시작 시간
     * @Param end 종료 시간
     * @throws IllegalArgumentException 시작시간이 종료시간보다 늦을때 발생한다.
     */

    public Item50(Date start, Date end){
        if(start.compareTo(end) == 1){
            throw new IllegalArgumentException();
        }
        this.start = new Date(start.getTime()) ;
        this.end = new Date(end.getTime());
    }

    public Date getStart(){
        return new Date(start.getTime());
    }

    public Date getEnd(){
        return new Date(end.getTime());
    }
}
