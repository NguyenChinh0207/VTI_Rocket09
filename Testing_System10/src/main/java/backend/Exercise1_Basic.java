package backend;

import utils.JdbcUtils;
import utils.ScannerUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Exercise1_Basic {

    private Connection connection;
    private JdbcUtils jdbcUtils;
    public Exercise1_Basic() throws IOException, SQLException, ClassNotFoundException {
        jdbcUtils=new JdbcUtils();
        connection= jdbcUtils.Connect();
    }


    public void Question1() throws SQLException, IOException, ClassNotFoundException {

        System.out.println("Connect success!!");
    }
    public void Question2() throws SQLException, IOException, ClassNotFoundException {

        Statement statement=connection.createStatement();
        String sql="SELECT * FROM `position`";
        ResultSet resultSet=statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println(resultSet.getInt("PositionID"));
            System.out.println(resultSet.getString("PositionName"));
            System.out.println("-----------");
        }

        connection.close();
    }
    public void Question3() throws SQLException {
        String sql = "	INSERT INTO `Position` (	PositionName	) "
                + "	VALUE 					(		?			)";
        PreparedStatement statement = connection.prepareStatement(sql);
        System.out.println("Nhap name:");
        String name= ScannerUtils.inputString("Name is not empty, please input name again");
        statement.setString(1, name);
        int effectedRecordAmount = statement.executeUpdate();
        System.out.println("Effected Record Amount :"+effectedRecordAmount);

    }
    public void Question4() throws SQLException {
        String sql = "	UPDATE `Position` SET PositionName = 'DEV' where PositionID=5 ";
        PreparedStatement statement = connection.prepareStatement(sql);
        int effectedRecordAmount = statement.executeUpdate();
        System.out.println("Effected Record Amount :"+effectedRecordAmount);
    }
    public void Question5() throws SQLException {
        String sql = "	DELETE FROM `Position` where PositionID=? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        System.out.println("Nhap id:");
        int id= ScannerUtils.inputInt("Please input a id as int, please input again.");
        statement.setInt(1, id);
        int effectedRecordAmount = statement.executeUpdate();
        System.out.println("Effected Record Amount :"+effectedRecordAmount);

    }
}
