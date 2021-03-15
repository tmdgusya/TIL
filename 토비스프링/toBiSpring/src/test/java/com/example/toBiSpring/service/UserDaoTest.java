package com.example.toBiSpring.service;

import com.example.toBiSpring.core.ConnectionMaker;
import com.example.toBiSpring.core.SimpleConnectionMaker;
import com.example.toBiSpring.entity.User;
import com.example.toBiSpring.product.DaoFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

class UserDaoTest {

    ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

    UserDao userDao;


    @BeforeEach
    void createUserDao() {
        userDao = context.getBean("getUserDao", UserDao.class);
    }

    @AfterEach
    void rollback() throws SQLException, ClassNotFoundException {
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();

        PreparedStatement ps = connection.prepareStatement("DELETE FROM users");
        ps.executeUpdate();

        ps.close();
    }

    @Test
    @DisplayName("User Entity 를 입력해주면 정상적으로 DB 에 등록되어야 한다.")
    void add() throws SQLException, ClassNotFoundException {
        User user = createUser("roach", "tmdgusya", "1234");
        userDao.add(user);
        assertThat(userDao.get("roach")).isEqualTo(user);
    }

    @Test
    @DisplayName("DB 에 존재하는 User Entity 를 정상적으로 가져온다.")
    void get() throws SQLException, ClassNotFoundException {
        User user = createUser("honux", "honux", "honux");
        userDao.add(user);
        assertThat(userDao.get("honux")).isEqualTo(user);
    }

    User createUser(String id, String name, String password) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        return user;
    }

    @Test
    @DisplayName("모든 유저를 정상적으로 삭제하는지 확인한다.")
    void deleteAll() throws SQLException, ClassNotFoundException {
        User user = createUser("honux", "honux", "honux");
        userDao.add(user);
        userDao.deleteAll();
        assertThat(userDao.get("honux")).isNull();
    }
}
