package TwoTimeRefactor;

import BeforeRefactoring.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class UserDao {

    public void add(User user) throws ClassNotFoundException, SQLException {
        String InsertUserQuery = "INSERT INTO User(id, name, password) values(?,?,?)";
        Connection conn = getConnection();

        PreparedStatement ps = conn.prepareStatement(InsertUserQuery);
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User get(String id) throws SQLException {
        String getUserQuery = "SELECT * FROM User WHERE id = ?";
        Connection conn = getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(getUserQuery);
        preparedStatement.setString(1, id);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getNString("name"));
        user.setName(rs.getString("password"));

        rs.close();
        preparedStatement.close();
        conn.close();

        return user;
    }

    public abstract Connection getConnection() throws SQLException;
}
