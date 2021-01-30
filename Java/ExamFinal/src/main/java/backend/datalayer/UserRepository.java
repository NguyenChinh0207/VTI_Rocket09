package backend.datalayer;

import entity.Project;
import entity.Role;
import entity.User;
import utils.JdbcUtils;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is User repository.
 *
 * @Description: .
 * @author: NTChinh
 * @create_date: January 13, 2021
 * @version: 1.0
 * @modifer: NTChinh
 * @modifer_date: January 13, 2021
 */

public class UserRepository implements IUserRepository {
    private JdbcUtils jdbcUtils;
    private Connection connection;

    /**
     * Constructor for class UserRepository.
     *
     * @Description: .
     * @author: NTChinh
     * @create_date: January 13, 2021
     * @version: 1.0
     * @modifer: NTChinh
     * @modifer_date: January 13, 2021
     * @throws IOException, SQLException, ClassNotFoundException
     */

    public UserRepository() throws IOException, SQLException, ClassNotFoundException {
        jdbcUtils = new JdbcUtils();
        connection = jdbcUtils.Connect();

    }


    @Override
    public List<User> getListUser() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User" ;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int userID=resultSet.getInt("ID");
            String fullName = resultSet.getString("FullName");
            String email = resultSet.getString("Email");
            String password = resultSet.getString("PassWord");
            Role role = Role.valueOf(resultSet.getString("Role"));

            User user = new User(userID,fullName, email, password, role);
            users.add(user);

        }

        return users;
    }

    @Override
    public List<User> getEmployeeManagerByIDProject(int id) throws Exception {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM User WHERE ProjectId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int userID=resultSet.getInt("ID");
            String fullName = resultSet.getString("FullName");
            String email = resultSet.getString("Email");
            String password = resultSet.getString("PassWord");
            Role role = Role.valueOf(resultSet.getString("Role"));

            User user = new User(userID,fullName, email, password, role);
            users.add(user);
        }

        return users;

    }

    @Override
    public List<User> getListManagerOfProject() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement statement = connection.createStatement();

        String listUser = "SELECT user.ID,user.FullName,user.Email, user.PassWord,user.Role" +
                " FROM project  LEFT JOIN user  ON  user.ID=project.IDManager" +
                " GROUP BY project.ProjectID" +
                " ORDER BY user.ID";
        ResultSet resultSet = statement.executeQuery(listUser);

        while (resultSet.next()) {
            int userID=resultSet.getInt("ID");
            String fullName = resultSet.getString("FullName");
            String email = resultSet.getString("Email");
            String password = resultSet.getString("PassWord");
            Role role = Role.valueOf(resultSet.getString("Role"));

            User user = new User(userID,fullName, email, password, role);
            users.add(user);

        }

        return users;
    }

    @Override
    public boolean isProjectExists(int id) throws SQLException {
        String sql = "SELECT *  FROM Project WHERE ProjectID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isUserExists(String fullname) throws SQLException {
        String sql = "SELECT *  FROM User WHERE ID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, fullname);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }



//    @Override
//    public User login(String email, String password) throws Exception {
//        String sql = "SELECT * FROM User " + "WHERE Email = ? AND Password = ? ";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
//        preparedStatement.setString(1, email);
//        preparedStatement.setString(2, password);
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        if (resultSet.next()) {
//            int userId = resultSet.getInt("ID");
//            String fullName = resultSet.getString("FullName");
//            Role role = Role.valueOf(resultSet.getString("Role"));
//            User user = new User(fullName, email, password, role);
//            return user;
//        } else {
//            throw new Exception("Tai khoan hoac mat khau sai!");
//        }
//    }



}
