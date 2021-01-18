package Factory;

import SeperateClass.ConnectionMaker;
import SeperateClass.DConnectionMaker;
import SeperateClass.NConnectionMaker;
import SeperateClass.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NaverUserDaoFactory {

    @Bean
    public UserDao getNaverUserDao(){
        UserDao userDao = new UserDao(getConnectionMaker());
        return userDao;
    }

    @Bean
    private ConnectionMaker getConnectionMaker(){
        ConnectionMaker connectionMaker = new NConnectionMaker();
        return connectionMaker;
    }
}
