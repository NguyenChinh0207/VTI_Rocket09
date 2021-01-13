package backend;

import utils.JdbcUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {
//    Question 1:
//    Tạo 1 method để thực thi các bước sau:
//    B1: xóa tất cả các nhân viên thuộc phòng ban 3
//    B2: xóa phòng ban 3
//    Với điều kiện: khi xóa B1 bị lỗi thì sẽ rollback lại
    private JdbcUtils jdbcUtils;
    private Connection connection;

    public Transaction() throws IOException, SQLException, ClassNotFoundException {
        jdbcUtils = new JdbcUtils();
        connection = jdbcUtils.Connect();
    }
    public void deleteDepartmentID3() throws Exception {
        // delete department
        String sqlString2 = "	DELETE FROM Department WHERE DepartmentID = 3";
        PreparedStatement preparedStatement2 = connection.prepareStatement(sqlString2);
        preparedStatement2.executeUpdate();
        System.out.println("delete Department success!");
    }
    public void deleteAllAccountOfDepartmentID3() throws SQLException {
        //delete all account off departmentID3
        String sqlString1 = "	DELETE FROM `Account` WHERE DepartmentID = 3";
        PreparedStatement preparedStatement1 = connection.prepareStatement(sqlString1);
        preparedStatement1.executeUpdate();
        System.out.println("Delete All Account of DepartmentID=3  success!");
    }
    public void Question1() throws SQLException {
        // turn off auto commit
        connection.setAutoCommit(false);
        try {
            deleteAllAccountOfDepartmentID3();
            deleteDepartmentID3();

            // commit transaction
            connection.commit();
            System.out.println("Transaction Commit!");

        } catch (Exception e) {
            System.out.println(e.getMessage());

            connection.rollback();
            System.out.println("Transaction Rollback!");
        }

        // turn on auto commit
        connection.setAutoCommit(true);


    }
}
