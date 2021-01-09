package SeperateClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker{
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        String DataBaseURL = "jdbc:h2:tcp://localhost/~/DaumDBCustom010";
        Connection conn = DriverManager.getConnection(DataBaseURL, "Daum", "1234");
        return conn;
    }
}
