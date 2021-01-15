package backend.businesslayer;

import backend.datalayer.UserRepository;
import backend.datalayer.IUserRepository;
import entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * This class is User service.
 *
 * @Description: .
 * @author: NTChinh
 * @create_date: January 13, 2021
 * @version: 1.0
 * @modifer: NTChinh
 * @modifer_date: January 13, 2021
 */
public class UserService implements IUserService {
    private IUserRepository repository;

    public UserService() throws SQLException, IOException, ClassNotFoundException {
        repository = new UserRepository();
    }

    @Override
    public List<User> getListUser() throws SQLException {
        return repository.getListUser();
    }

    @Override
    public List<User> getEmployeeManagerByIDProject(int id) throws Exception {
        return repository.getEmployeeManagerByIDProject(id);
    }

    @Override
    public List<User> getListManagerOfProject() throws SQLException {
        return repository.getListManagerOfProject();
    }

    @Override
    public boolean isProjectExists(int id) throws SQLException {
        return repository.isProjectExists(id);
    }

    @Override
    public boolean isUserExists(String fullname) throws SQLException {
        return repository.isUserExists(fullname);
    }




}
