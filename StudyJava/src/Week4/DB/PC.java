package Week4.DB;

public class PC {

    private int pc_id;
    private int in_use;

    public PC(int pc_id, int in_use) {
        this.pc_id = pc_id;
        this.in_use = in_use;
    }

    public int getPc_id() {
        return pc_id;
    }

    public int getIn_use() {
        return in_use;
    }
}
