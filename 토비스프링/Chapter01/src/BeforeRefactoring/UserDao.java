package BeforeRefactoring;

import java.sql.*;

public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException {
        String DataBaseURL = "jdbc:h2:~/tobySpring";
        String InsertUserQuery = "INSERT INTO User(id, name, password) values(?,?,?)";

        Connection conn = DriverManager.getConnection(DataBaseURL, "sa", "");

        PreparedStatement ps = conn.prepareStatement(InsertUserQuery);
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        String DataBaseURL = "jdbc:h2:~/tobySpring";
        String getUserQuery = "SELECT * FROM User WHERE id = ?";
        Connection conn = DriverManager.getConnection(DataBaseURL, "sa", "");
        PreparedStatement preparedStatement = conn.prepareStatement(getUserQuery);
        preparedStatement.setString(1, id);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getNString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        preparedStatement.close();
        conn.close();

        return user;
    }

}
