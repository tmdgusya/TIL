package roach.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {

    private String url = "jdbc:mysql://localhost:3307/tobi";
    private String userName = "root";
    private String password = "1234";

    public Connection makeNewConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, userName, password);
    }

}
