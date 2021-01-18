package TwoTimeRefactor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DUserDao extends UserDao{
    @Override
    public Connection getConnection() throws SQLException {
        String DataBaseURL = "jdbc:h2:~/DaumDB";
        Connection conn = DriverManager.getConnection(DataBaseURL, "Daum", "");
        return conn;
    }
}
