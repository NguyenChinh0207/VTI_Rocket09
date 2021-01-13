package backend;

import utils.JdbcUtils;
import utils.ScannerUtils;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Ex3_Call_Procerduce {
    private JdbcUtils jdbcUtils;
    private DepartmentDao departmentDao;
    private Connection connection;
    public Ex3_Call_Procerduce() throws IOException, SQLException, ClassNotFoundException {
        jdbcUtils = new JdbcUtils();
        connection = jdbcUtils.Connect();
        departmentDao = new DepartmentDao();

    }

    public void deleteDepartmentProcedure(int id) throws Exception {
        if(!departmentDao.isDepartmentIDExists(id)){
            throw new Exception("Cannot find department which has id= " + id);
        }
        else{
            String sql="{CALL sp_delete_department(?)}";
            CallableStatement callableStatement=connection.prepareCall(sql);

            callableStatement.setInt(1,id);
            int effectedRecordAmount = callableStatement.executeUpdate();
            System.out.println("Effected Record Amount :" + effectedRecordAmount);
            jdbcUtils.disConnect();
        }
    }
    public void Question1() throws Exception {
        System.out.println("Nhap department id can update:");
        int id = ScannerUtils.inputInt("Please input a id as int, please input again.");
        deleteDepartmentProcedure(id);

    }
}
