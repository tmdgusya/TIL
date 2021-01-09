package SeperateClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker{
    @Override
    public Connection getConnection() throws SQLException {
        String DataBaseURL = "jdbc:h2:~/DaumDB";
        Connection conn = DriverManager.getConnection(DataBaseURL, "Daum", "");
        return conn;
    }
}
