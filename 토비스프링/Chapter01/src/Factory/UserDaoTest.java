package Factory;

import BeforeRefactoring.User;
import SeperateClass.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ApplicationContext ac = new AnnotationConfigApplicationContext(DaumUserDaoFactory.class);
        UserDao userDao =  ac.getBean("getDaumUserDao", UserDao.class);
        User user = new User();
        user.setId("1");
        user.setName("jsh");
        user.setPassword("1234");
        userDao.add(user);

        User user1 = userDao.get("1");
        System.out.println(user1.getPassword());
        assertion("jsh", user1.getName());
    }

    public static String assertion(String expected, String result) {
        if(expected.equals(result)){
            return "Success";
        }else{
            return "Fail";
        }
    }
}
