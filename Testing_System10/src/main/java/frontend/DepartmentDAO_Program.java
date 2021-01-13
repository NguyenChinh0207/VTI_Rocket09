package frontend;

import backend.DepartmentDao;

import java.io.IOException;
import java.sql.SQLException;

public class DepartmentDAO_Program {
    public static void main(String[] args) throws Exception {
        DepartmentDao departmentDao=new DepartmentDao();
        departmentDao.Question1();
        departmentDao.Question2_3();
        departmentDao.Question4();
        departmentDao.Question5();
        departmentDao.Question6();
        departmentDao.Question7();
    }
}
