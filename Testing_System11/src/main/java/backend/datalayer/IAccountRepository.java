package backend.datalayer;

import entity.Account;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public interface IAccountRepository {
    List<Account> getListAccounts() throws SQLException, ClassNotFoundException;
    void createAccount(String email, String username, String fullname, LocalDate createdate) throws Exception;
    Account getAccountByID(int id) throws Exception;
    boolean isAccountExists(int id) throws SQLException;
    boolean isAccountExists(String username) throws SQLException;
    void updateAccountByID(int id, String newName) throws Exception;
    void deleteAccount(int id) throws Exception;

}
