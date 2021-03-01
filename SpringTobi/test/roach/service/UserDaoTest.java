package roach.service;

import org.junit.jupiter.api.*;
import roach.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.*;

class UserDaoTest {

    UserDao userDao;
    String url = "jdbc:mysql://localhost:3307/tobi";
    String userName = "root";
    String password = "1234";

    @BeforeEach
    void createUserDao(){
        userDao = new UserDao();
    }

    @AfterEach
    void rollback() throws SQLException {
        Connection connection = DriverManager.getConnection(url, userName, password);

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
}
