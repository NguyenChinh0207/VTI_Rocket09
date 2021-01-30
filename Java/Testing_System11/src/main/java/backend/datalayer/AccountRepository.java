package backend.datalayer;

import entity.Account;
import utils.JdbcUtils;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository {
    private JdbcUtils jdbcUtils;
    private Connection connection;

    public AccountRepository() throws SQLException, IOException, ClassNotFoundException {
        jdbcUtils = new JdbcUtils();
        connection = jdbcUtils.Connect();
    }
    @Override
    public List<Account> getListAccounts() throws SQLException, ClassNotFoundException {
        List<Account> accounts = new ArrayList<>();
        Connection connection = jdbcUtils.Connect();
        String sql = "SELECT * FROM `Account`";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Account account = new Account();
            account.setAccountID(resultSet.getInt("AccountID"));
            account.setEmail(resultSet.getString("Email"));
            account.setUserName(resultSet.getString("UserName"));
            account.setFullName(resultSet.getString("FullName"));
            account.setCreateDate((LocalDate) resultSet.getObject("CreateDate"));
            accounts.add(account);
        }
        jdbcUtils.disConnect();
        return accounts;
    }


    @Override
    public Account getAccountByID(int id) throws Exception {
        String sql = "SELECT * FROM Account WHERE AccountID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Account account = new Account();
            account.setAccountID(resultSet.getInt("AccountID"));
            account.setEmail(resultSet.getString("Email"));
            account.setUserName(resultSet.getString("UserName"));
            account.setFullName(resultSet.getString("FullName"));
            account.setCreateDate((LocalDate) resultSet.getObject("CreateDate"));

            return account;
        } else {
            jdbcUtils.disConnect();
            throw new Exception("Cannot find account which has id= " + id);
        }
    }

    @Override
    public void createAccount(String email, String username, String fullname, LocalDate createdate) throws Exception {
        if (isAccountExists(username)) {
            throw new Exception("Account name is exist: " + username);
        } else {
            String sql = "	INSERT INTO Account(Email, UserName, FullName, CreateDate)	VALUE(   ?,?,?,?	)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, fullname);
            preparedStatement.setObject(4, createdate);

            int effectedRecordAmount = preparedStatement.executeUpdate();
            System.out.println("Effected Record Amount :" + effectedRecordAmount);
        }
    }

    @Override
    public boolean isAccountExists(int id) throws SQLException {
        String sql = "SELECT *  FROM Account WHERE AccountID = ?";
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
    public boolean isAccountExists(String username) throws SQLException {
        String sql = "SELECT *  FROM Account WHERE UserName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void updateAccountByID(int id, String newName) throws Exception {
        if (!isAccountExists(id)) {
            throw new Exception("Cannot find account which has id= " + id);
        } else {
            if (isAccountExists(newName)) {
                throw new Exception("Username is exists! ");
            }

            String sql = "UPDATE Account SET username = ? WHERE AccountID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newName);
            preparedStatement.setInt(2, id);
            int effectedRecordAmount = preparedStatement.executeUpdate();
            System.out.println("Effected Record Amount :" + effectedRecordAmount);
        }
    }

    @Override
    public void deleteAccount(int id) throws Exception {
        if(!isAccountExists(id)){
            throw new Exception("Cannot find account which has id= " + id);
        }
        else{
            String sql = "DELETE FROM Account WHERE AccountID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int effectedRecordAmount = preparedStatement.executeUpdate();
            System.out.println("Effected Record Amount :" + effectedRecordAmount);
        }
    }
}
