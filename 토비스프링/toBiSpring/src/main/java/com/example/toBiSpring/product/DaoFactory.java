package com.example.toBiSpring.product;

import com.example.toBiSpring.core.SimpleConnectionMaker;
import com.example.toBiSpring.service.UserDao;

public class DaoFactory {

    public static UserDao getUserDao() {
        return new UserDao(new SimpleConnectionMaker());
    }
}
