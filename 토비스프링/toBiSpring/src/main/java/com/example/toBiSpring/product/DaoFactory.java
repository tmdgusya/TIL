package com.example.toBiSpring.product;

import com.example.toBiSpring.core.ConnectionMaker;
import com.example.toBiSpring.core.SimpleConnectionMaker;
import com.example.toBiSpring.service.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao getUserDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new SimpleConnectionMaker();
    }

}
