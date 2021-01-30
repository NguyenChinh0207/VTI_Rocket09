package backend.presentationlayer;

import backend.businesslayer.AccountService;
import backend.businesslayer.IAccountService;
import backend.datalayer.AccountRepository;
import entity.Account;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class AccountController {
    private IAccountService service;

    public AccountController() throws SQLException, IOException, ClassNotFoundException {
        service = new AccountService();
    }

    public List<Account> getListAccounts() throws SQLException, ClassNotFoundException {
        return service.getListAccounts();
    }
    public Account getAccountByID(int id) throws Exception {
        return service.getAccountByID(id);
    }

    public void createAccount(String email, String username, String fullname, LocalDate createdate) throws Exception {
        // validation
        if (username == null || username.length() < 6) {
            throw new Exception(
                    "User name must be greater than 6 characters ");
        }

        service.createAccount(email, username, fullname, createdate);
    }

    public boolean isAccountExists(int id) throws SQLException {
        return service.isAccountExists(id);
    }

    public boolean isAccountExists(String username) throws SQLException {
        return service.isAccountExists(username);
    }

    public void updateAccountByID(int id, String newName) throws Exception {
        service.updateAccountByID(id, newName);
    }

    public void deleteAccount(int id) throws Exception {
        service.deleteAccount(id);
    }
}
