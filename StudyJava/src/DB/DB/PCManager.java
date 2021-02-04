package DB.DB;

import java.sql.*;
import java.util.ArrayList;

public class PCManager {

    public ArrayList<PC> getVacantSeats() {
        final ArrayList<PC> vacantSeatList = new ArrayList<>();
        String getPCInfoQuery = "SELECT * FROM PC WHERE in_use = 0";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getPCInfoQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            ) {
            while(resultSet.next()){
                PC pc = new PC(resultSet.getInt("pc_id"), resultSet.getInt("in_use"));
                vacantSeatList.add(pc);
            }
        }catch (SQLException e){
            System.out.println("빈자리 호출 에러 = " + e);
        }
        return vacantSeatList;
    }

    public void showVancantSeatList(){
        System.out.println("빈 자리는 다음과 같습니다.");
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder vacantSeatListMessageBuilder = new StringBuilder("[ ");
        for(PC pc : getVacantSeats()){
            vacantSeatListMessageBuilder.append(pc.getPc_id()).append(" ");
        }
        vacantSeatListMessageBuilder.append("]");
        return vacantSeatListMessageBuilder.toString();
    }

    public void addPc(int pc){
        String query = String.format("insert into PC (pc_id, in_use) VALUES (%d,0)", pc);
        try(
            final Connection connection = DBConnection.getConnection();
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("PC ADD ERROR = " + e);
        }
    }

    public void Assignment(User user, PC pc){
        String userQuery =
                String.format("insert into User (user_id, start_time, pc) VALUES (%d, '%s', %d)", user.getUser_id(), user.getStartDate(), pc.getPc_id());
        String pcInUserColumnUpdateQuery = String.format("update PC set in_use = 1 where pc_id = %d", pc.getPc_id());
        try(
                final Connection connection = DBConnection.getConnection();
                PreparedStatement userQuerypsmt = connection.prepareStatement(userQuery);
                PreparedStatement pcQueryPsmt = connection.prepareStatement(pcInUserColumnUpdateQuery);
        ) {
            userQuerypsmt.executeUpdate();
            pcQueryPsmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("자리 추가에서 문제가 발생했습니다. = " + e);
        }
    }

    public int stop(User user){
        String getPC = String.format("select pc from User where user_id = %d", user.getUser_id());
        String userEndTimeUpdate = String.format("update User set end_time = '%s', pc = null where user_id = %d", user.getEndDate(), user.getUser_id());
        int pc_id = 0;
        try(
                final Connection connection = DBConnection.getConnection();
                PreparedStatement getPCQuery = connection.prepareStatement(getPC);
                PreparedStatement userUpdateQuery = connection.prepareStatement(userEndTimeUpdate);
        ) {
            ResultSet PCSet = getPCQuery.executeQuery();
            while (PCSet.next()){
                pc_id = PCSet.getInt("pc");
                updatePCInUseFalse(connection, pc_id);
            }
            userUpdateQuery.executeUpdate();
            return pc_id;
        }catch (SQLException e){
            System.out.println("자리 삭제 에서 문제가 발생했습니다. = " + e);
        }
        return 0;
    }

    private void updatePCInUseFalse(Connection connection, int pc_id) throws SQLException {
        final String pcUpdateQuery = String.format("update PC set in_use = 0 where pc_id = '%d'", pc_id);
        try(PreparedStatement preparedStatement = connection.prepareStatement(pcUpdateQuery);) {
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            System.out.println("PC 자리 수정중 오류발생!");
        }
    }
}
