package com.example.toBiSpring.core;

import com.example.toBiSpring.StatementStartegy.DeleteAllStatement;
import com.example.toBiSpring.StatementStartegy.StatementStrategy;
import com.example.toBiSpring.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcContext {

    private final DataSource dataSource;

    public JdbcContext(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void jdbcWithStatementStrategy(StatementStrategy stmt) throws SQLException {
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
