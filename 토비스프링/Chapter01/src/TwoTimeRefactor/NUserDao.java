package TwoTimeRefactor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao{

    @Override
    public Connection getConnection() throws SQLException {
        String DataBaseURL = "jdbc:h2:~/NaverDB";
        Connection conn = DriverManager.getConnection(DataBaseURL, "sa", "");
        return conn;
    }
}
