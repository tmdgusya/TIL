package com.example.toBiSpring.service;


import com.example.toBiSpring.StatementStartegy.AddStatement;
import com.example.toBiSpring.StatementStartegy.DeleteAllStatement;
import com.example.toBiSpring.StatementStartegy.StatementStrategy;
import com.example.toBiSpring.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private final DataSource dataSource;

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Insert User Entity data at DB User table
     *
     * @param user (User Entity)
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy st = new AddStatement(user);
        jdbcContextWithStatementStrategy(st);
    }

    /**
     * If there's a user tuple in the database with the same ID, Gets the user(tuple) from the database
     *
     * @param id (user id)
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection connection = dataSource.getConnection();

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();

        if (isNotExistUser(rs)) return null;

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

    private boolean isNotExistUser(ResultSet rs) throws SQLException {
        return !rs.isBeforeFirst();
    }

    public void deleteAll() throws SQLException {
        StatementStrategy statementStrategy = new DeleteAllStatement();
        jdbcContextWithStatementStrategy(statementStrategy);
    }

    public void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        try {
            c = dataSource.getConnection();
            ps = stmt.makePreparedStatement(c);
            ps.executeUpdate();
        }catch (SQLException e) {
            throw e;
        }finally {
            c.close();
            ps.close();
        }
    }

}
