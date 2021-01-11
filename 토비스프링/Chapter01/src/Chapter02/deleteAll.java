package Chapter02;

import SeperateClass.ConnectionMaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteAll {

    private ConnectionMaker connectionMaker;

    public deleteAll(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void delete(String id) throws SQLException, ClassNotFoundException {

        Connection conn = null;
        PreparedStatement ps = null;

        String deleteUserQuery = "DELETE FROM USER WHERE id = ?";

        try{
            conn = connectionMaker.getConnection();
            ps = conn.prepareStatement(deleteUserQuery);
            ps.setString(1,id);
            ps.executeUpdate();
        }catch (SQLException e){
            throw e;
        }finally {
            if(ps != null){
                try {
                    ps.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }


        ps.close();
        conn.close();
    }
}
