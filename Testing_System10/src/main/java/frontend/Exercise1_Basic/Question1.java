package frontend.Exercise1_Basic;

import backend.Exercise1_Basic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static backend.Exercise1_Basic.getConnection;

public class Question1 {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Connection connection = getConnection();
        System.out.println("Connect success!!");

    }
}
