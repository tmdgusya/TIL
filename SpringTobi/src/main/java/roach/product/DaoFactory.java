package main.roach.product;

import main.roach.core.SimpleConnectionMaker;
import main.roach.service.UserDao;

public class DaoFactory {

    public static UserDao getUserDao() {
        return new UserDao(new SimpleConnectionMaker());
    }
}
