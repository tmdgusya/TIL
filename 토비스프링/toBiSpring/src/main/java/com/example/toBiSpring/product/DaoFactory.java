package com.example.toBiSpring.product;

import com.example.toBiSpring.core.ConnectionMaker;
import com.example.toBiSpring.core.JdbcContext;
import com.example.toBiSpring.core.SimpleConnectionMaker;
import com.example.toBiSpring.service.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class DaoFactory {

    @Bean
    public UserDao getUserDao() {
        return new UserDao(new JdbcContext(dataSource()));
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new SimpleConnectionMaker();
    }

    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost:3307/tobi");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        return dataSource;
    }
}
