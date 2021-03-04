package com.example.toBiSpring.service;


import com.example.toBiSpring.StatementStartegy.AddStatement;
import com.example.toBiSpring.StatementStartegy.DeleteAllStatement;
import com.example.toBiSpring.StatementStartegy.StatementStrategy;
import com.example.toBiSpring.core.JdbcContext;
import com.example.toBiSpring.entity.User;
import com.example.toBiSpring.product.DaoFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    /**
     * Insert User Entity data at DB User table
     * @param user (User Entity)
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy st = new AddStatement(user);
        jdbcContext.jdbcWithStatementStrategy(st);
    }

    /**
     * If there's a user tuple in the database with the same ID, Gets the user(tuple) from the database
     * @param id (user id)
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public User get(String id) throws ClassNotFoundException, SQLException {

        Connection connection = new AnnotationConfigApplicationContext(DaoFactory.class).getBean("dataSource", DataSource.class).getConnection();

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
        jdbcContext.jdbcWithStatementStrategy(statementStrategy);
    }

}
