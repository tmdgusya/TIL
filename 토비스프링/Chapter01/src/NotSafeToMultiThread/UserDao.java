package NotSafeToMultiThread;

import BeforeRefactoring.User;
import SeperateClass.ConnectionMaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private ConnectionMaker connectionMaker;
    private Connection conn;
    private User user;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        String InsertUserQuery = "INSERT INTO User(id, name, password) values(?,?,?)";
        this.conn = connectionMaker.getConnection();
        PreparedStatement ps = this.conn.prepareStatement(InsertUserQuery);
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        this.conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        String getUserQuery = "SELECT * FROM User WHERE id = ?";
        this.conn = connectionMaker.getConnection();
        PreparedStatement preparedStatement = this.conn.prepareStatement(getUserQuery);
        preparedStatement.setString(1, id);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        this.user.setId(rs.getString("id"));
        this.user.setName(rs.getString("name"));
        this.user.setPassword(rs.getString("password"));

        rs.close();
        preparedStatement.close();
        this.conn.close();

        return user;
    }
}
