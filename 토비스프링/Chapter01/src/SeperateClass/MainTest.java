package SeperateClass;

public class MainTest {

    ConnectionMaker dConn = new DConnectionMaker();
    ConnectionMaker nConn = new NConnectionMaker();

    UserDao dUserDao = new UserDao(dConn);
    UserDao nUserDao = new UserDao(nConn);
}
