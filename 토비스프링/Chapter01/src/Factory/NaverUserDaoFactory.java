package Factory;

import SeperateClass.ConnectionMaker;
import SeperateClass.DConnectionMaker;
import SeperateClass.NConnectionMaker;
import SeperateClass.UserDao;

public class NaverUserDaoFactory {
    public UserDao getNaverUserDao(){
        UserDao userDao = new UserDao(getConnectionMaker());
        return userDao;
    }

    private ConnectionMaker getConnectionMaker(){
        ConnectionMaker connectionMaker = new NConnectionMaker();
        return connectionMaker;
    }
}
