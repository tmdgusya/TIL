package roach.service;

import roach.entity.User;

import java.sql.*;

public class UserDao {

    private String url = "jdbc:mysql://localhost:3307/tobi";
    private String userName = "root";
    private String password = "1234";

    /**
     * Insert User Entity data at DB User table
     * @param user (User Entity)
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void add(User user) throws ClassNotFoundException, SQLException {

        Connection connection = getConnection();

        PreparedStatement ps = connection.prepareStatement("INSERT INTO users(id, name, password) values (?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        connection.close();
    }

    /**
     * If there's a user tuple in the database with the same ID, Gets the user(tuple) from the database
     * @param id (user id)
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection connection = getConnection();

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        connection.close();

        return user;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, userName, password);
    }
}
