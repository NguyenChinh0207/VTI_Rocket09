package backend.presentationlayer;

import backend.businesslayer.UserService;
import backend.businesslayer.IUserService;
import entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * This class is User Controller.
 *
 * @Description: .
 * @author: NTChinh
 * @create_date: January 13, 2021
 * @version: 1.0
 * @modifer: NTChinh
 * @modifer_date: January 13, 2021
 */
public class UserController {
    private IUserService service;

    public UserController() throws SQLException, IOException, ClassNotFoundException {
        service=new UserService();
    }

    public List<User> getListUser() throws SQLException {
        return service.getListUser();
    }

    public List<User> getEmployeeManagerByIDProject(int id) throws Exception {
        return service.getEmployeeManagerByIDProject(id);
    }

    public List<User> getListManagerOfProject() throws SQLException {
        return service.getListManagerOfProject();
    }

    public boolean isProjectExists(int id) throws SQLException {
        return service.isProjectExists(id);
    }

    public boolean isUserExists(String fullname) throws SQLException {
        return service.isUserExists(fullname);
    }



}
