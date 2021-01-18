package SeperateClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NConnectionMaker implements ConnectionMaker{
    @Override
    public Connection getConnection() throws SQLException {
        String DataBaseURL = "jdbc:h2:~/NaverDB";
        Connection conn = DriverManager.getConnection(DataBaseURL, "Naver", "");
        return conn;
    }
}
