import BeforeRefactoring.User;
import Factory.DaumUserDaoFactory;
import SeperateClass.UserDao;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Rollback;

import java.sql.SQLException;

public class UserDaoTest {

    @After
    public void rollback() throws SQLException, ClassNotFoundException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DaumUserDaoFactory.class);
        UserDao userDao =  ac.getBean("getDaumUserDao", UserDao.class);
        userDao.delete("1");
    }

    @Test
    public void userDaoTest() throws SQLException, ClassNotFoundException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DaumUserDaoFactory.class);
        UserDao userDao =  ac.getBean("getDaumUserDao", UserDao.class);

        String ExpectedName = "jsh";
        User user = new User();
        user.setId("1");
        user.setName(ExpectedName);
        user.setPassword("1234");
        userDao.add(user);

        User result = userDao.get("1");

        Assertions.assertThat(ExpectedName).isEqualTo(result.getName());

    }
}
