package SeperateClass;

import BeforeRefactoring.User;

import java.sql.*;

public class UserDao{

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        String InsertUserQuery = "INSERT INTO User(id, name, password) values(?,?,?)";
        Connection conn = connectionMaker.getConnection();
        PreparedStatement ps = conn.prepareStatement(InsertUserQuery);
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        String getUserQuery = "SELECT * FROM User WHERE id = ?";
        Connection conn = connectionMaker.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(getUserQuery);
        preparedStatement.setString(1, id);

        ResultSet rs = preparedStatement.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        preparedStatement.close();
        conn.close();

        return user;
    }


    public void delete(String id) throws SQLException, ClassNotFoundException {
        String deleteUserQuery = "DELETE FROM USER WHERE id = ?";
        Connection conn = connectionMaker.getConnection();
        PreparedStatement preparedStatement = conn.prepareStatement(deleteUserQuery);
        preparedStatement.setString(1,id);
        preparedStatement.executeUpdate();
    }

}
