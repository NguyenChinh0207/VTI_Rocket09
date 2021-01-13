package backend.businesslayer;

import backend.datalayer.AccountRepository;
import backend.datalayer.IAccountRepository;
import entity.Account;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountService implements  IAccountService{
    private IAccountRepository repository;
    public AccountService() throws SQLException, IOException, ClassNotFoundException {
        repository = new AccountRepository();
    }
    @Override
    public List<Account> getListAccounts() throws SQLException, ClassNotFoundException {
        return repository.getListAccounts();
    }

    @Override
    public void createAccount(String email, String username, String fullname, LocalDate createdate) throws Exception {
        repository.createAccount(email,username,fullname,createdate);
    }

    @Override
    public Account getAccountByID(int id) throws Exception {
        return repository.getAccountByID(id);
    }

    @Override
    public boolean isAccountExists(int id) throws SQLException {
        return repository.isAccountExists(id);
    }

    @Override
    public boolean isAccountExists(String username) throws SQLException {
        return repository.isAccountExists(username);
    }

    @Override
    public void updateAccountByID(int id, String newName) throws Exception {
        repository.updateAccountByID(id, newName);
    }

    @Override
    public void deleteAccount(int id) throws Exception {
        repository.deleteAccount(id);
    }

}
