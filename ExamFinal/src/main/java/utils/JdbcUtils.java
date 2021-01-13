package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static Connection connection;
    private static Properties properties;

    public JdbcUtils() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/database.properties"));
        properties.load(new FileInputStream("src/main/resource/message.properties"));

    }
    public void isConnectForTesting() throws SQLException, ClassNotFoundException {
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        Class.forName(properties.getProperty("driver"));

        connection = DriverManager.getConnection(url, username, password);

        System.out.println("Connect success!");

    }
    public static Connection Connect() throws SQLException, ClassNotFoundException {
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        Class.forName(properties.getProperty("driver"));

        connection= DriverManager.getConnection(url, username, password);
        return connection;
    }
    public void disConnect() throws SQLException {
        connection.close();
    }
}
