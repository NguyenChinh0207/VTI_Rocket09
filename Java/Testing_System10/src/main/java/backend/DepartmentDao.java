package backend;

import entity.Department;
import utils.JdbcUtils;
import utils.ScannerUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    private JdbcUtils jdbcUtils;
    private  Connection connection;
    public DepartmentDao() throws IOException, SQLException, ClassNotFoundException {
       jdbcUtils = new JdbcUtils();
        connection = jdbcUtils.Connect();
    }

    public List<Department> getDepartment() throws SQLException, IOException, ClassNotFoundException {
        List<Department> departments = new ArrayList<>();

        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM Department";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Department department = new Department();
            department.setDepartmentID(resultSet.getInt("DepartmentID"));
            department.setDepartmentName(resultSet.getString("DepartmentName"));
            departments.add(department);
        }
        return departments;

    }

    public Department getDepartmentByID(int id) throws Exception {
        String sql = "SELECT * FROM Department WHERE DepartmentID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Department department = new Department();
            department.setDepartmentID(resultSet.getInt("DepartmentID"));
            department.setDepartmentName(resultSet.getString("DepartmentName"));

            return department;
        } else {
            throw new Exception("Cannot find department which has id= " + id);
        }
    }

    public boolean isDepartmentNameExists(String name) throws SQLException, IOException, ClassNotFoundException {

        String sql = "SELECT *  FROM Department WHERE DepartmentName = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isDepartmentIDExists(int id) throws SQLException, IOException, ClassNotFoundException {

        String sql = "SELECT *  FROM Department WHERE DepartmentID = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }

    }

    public void createDepartment(String name) throws Exception {
        if (isDepartmentNameExists(name)) {
            throw new Exception("Department name is exist: " + name);
        } else {

            String sql = "	INSERT INTO Department(DepartmentName)	VALUE(   ?	)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            int effectedRecordAmount = preparedStatement.executeUpdate();
            System.out.println("Effected Record Amount :" + effectedRecordAmount);
        }

    }

    public void updateDepartmentName(int id, String newName) throws Exception {
        if (!isDepartmentIDExists(id)) {
            throw new Exception("Cannot find department which has id= " + id);
        } else {
            if (isDepartmentNameExists(newName)) {
                throw new Exception("Department name is exists! ");
            }

            String sql = "UPDATE Department SET DepartmentName = ? WHERE DepartmentID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            int effectedRecordAmount = preparedStatement.executeUpdate();
            System.out.println("Effected Record Amount :" + effectedRecordAmount);
        }
    }
    public void deleteDepartment(int id) throws Exception {
        if(!isDepartmentIDExists(id)){
            throw new Exception("Cannot find department which has id= " + id);
        }
        else{

            String sql = "DELETE FROM Department WHERE DepartmentID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int effectedRecordAmount = preparedStatement.executeUpdate();
            System.out.println("Effected Record Amount :" + effectedRecordAmount);
        }
    }
    //    -------------------------------------------------------------
    public void Question1() throws IOException, SQLException, ClassNotFoundException {
        List<Department> departments = new DepartmentDao().getDepartment();
        for (Department department : departments) {
            System.out.println(department);
        }

    }

    public void Question2_3() throws Exception {
        System.out.println("Nhap id: ");
        int inputId = ScannerUtils.inputInt("Please input a id as int, please input again.");

        Department department = new DepartmentDao().getDepartmentByID(inputId);
        System.out.println(department);
    }

    public void Question4() throws IOException, SQLException, ClassNotFoundException {
        System.out.println("Nhap name:");
        String name = ScannerUtils.inputString("Please input is not empty, please input again.");
        boolean rs = new DepartmentDao().isDepartmentNameExists(name);
        System.out.println("Is exists:" + rs);
    }

    public void Question5() throws Exception {
        System.out.println("Nhap department name:");
        String name = ScannerUtils.inputString("Please input is not empty, please input again.");
        new DepartmentDao().createDepartment(name);
    }

    public void Question6() throws Exception {
        System.out.println("Nhap department id can update:");
        int id = ScannerUtils.inputInt("Please input a id as int, please input again.");
        System.out.println("Nhap department name can update:");
        String newName = ScannerUtils.inputString("Please input is not empty, please input again.");

        new DepartmentDao().updateDepartmentName(id,newName);
    }
    public void Question7() throws Exception {
        System.out.println("Nhap department id can delete:");
        int id = ScannerUtils.inputInt("Please input a id as int, please input again.");
        new DepartmentDao().deleteDepartment(id);
    }
}
