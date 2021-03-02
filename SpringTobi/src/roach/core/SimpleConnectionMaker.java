package roach.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker implements ConnectionMaker{

    private String url = "jdbc:mysql://localhost:3307/tobi";
    private String userName = "root";
    private String password = "1234";

    @Override
    public Connection makeConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, userName, password);
    }

}
