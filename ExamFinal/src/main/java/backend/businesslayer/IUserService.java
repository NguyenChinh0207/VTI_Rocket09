package backend.businesslayer;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    List<User> getListUser() throws SQLException;
    List<User> getEmployeeManagerByIDProject(int id) throws Exception;
    List<User> getListManagerOfProject() throws SQLException;
    boolean isProjectExists(int id) throws SQLException;
    boolean isUserExists(String fullname) throws SQLException;



}
