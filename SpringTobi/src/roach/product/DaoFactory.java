package roach.product;

import roach.core.SimpleConnectionMaker;
import roach.service.UserDao;

public class DaoFactory {

    public static UserDao getUserDao() {
        return new UserDao(new SimpleConnectionMaker());
    }
}
