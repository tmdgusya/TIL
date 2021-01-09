package Factory;

import SeperateClass.ConnectionMaker;
import SeperateClass.DConnectionMaker;
import SeperateClass.NConnectionMaker;
import SeperateClass.UserDao;

public class DaumUserDaoFactory {

    public UserDao getDaumUserDao(){
        UserDao userDao = new UserDao(getConnectionMaker());
        return userDao;
    }

    private ConnectionMaker getConnectionMaker(){
        ConnectionMaker connectionMaker = new DConnectionMaker();
        return connectionMaker;
    }
}
