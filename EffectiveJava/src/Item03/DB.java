package Item03;

public class DB {

    private DB(){}
    public static DB getInstance(){
        return LazyHolder.INSTANCE;
    }

    public static class LazyHolder {
        private static final DB INSTANCE = new DB();
    }
}
