package backend.datalayer;

import entity.Manager;
import entity.Project;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    /**
     * This method is used for getting list user.
     *
     * @Description: .
     * @author: NTChinh
     * @create_date: January 13, 2021
     * @version: 1.0
     * @modifer: NTChinh
     * @modifer_date: January 13, 2021
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    List<User> getListUser() throws SQLException;
    List<User> getEmployeeManagerByIDProject(int id) throws Exception;
    List<User> getListManagerOfProject() throws SQLException;
    boolean isProjectExists(int id) throws SQLException;
    boolean isUserExists(String  fullname) throws SQLException;
//    User login(String email, String password) throws Exception;


}
