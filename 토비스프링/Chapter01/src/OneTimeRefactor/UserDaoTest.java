package OneTimeRefactor;

import Factory.DaumUserDaoFactory;
import SeperateClass.UserDao;

public class UserDaoTest {
    public static void main(String[] args) {
        UserDao userDao = new DaumUserDaoFactory().getDaumUserDao();
    }
}
