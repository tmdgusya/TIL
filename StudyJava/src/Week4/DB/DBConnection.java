package Week4.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = "jdbc:mysql://localhost:3307/sqad";

    static public Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("DB 드라이버를 찾지 못했습니다.");
        }
        try{
            conn = DriverManager.getConnection(url, "user", "1234");
            System.out.println("연결 성공");
            return conn;
        }
        catch (SQLException e){
            System.out.println("error" + " = " + e);
        }
        return conn;
    }
}
