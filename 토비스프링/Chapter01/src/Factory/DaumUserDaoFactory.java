package Factory;

import SeperateClass.ConnectionMaker;
import SeperateClass.DConnectionMaker;
import SeperateClass.NConnectionMaker;
import SeperateClass.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaumUserDaoFactory {

    @Bean
    public UserDao getDaumUserDao(){
        UserDao userDao = new UserDao(getConnectionMaker());
        return userDao;
    }

    @Bean
    public ConnectionMaker getConnectionMaker(){
        ConnectionMaker connectionMaker = new DConnectionMaker();
        return connectionMaker;
    }
}
