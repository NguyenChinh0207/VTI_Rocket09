import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Programe {

    public static Connection getConnection()
            throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/database.properties"));

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        // register the driver class with DriverManager
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Step 2: get a Database Connection
        return DriverManager.getConnection(url, username, password);
    }

    public static void main(String[] args)
            throws ClassNotFoundException, FileNotFoundException, SQLException, IOException {

        Connection connection = getConnection();

        // turn off auto commit
        connection.setAutoCommit(false);

        // Create Group
        try {
            createGroup(connection);
            createUser(connection);
            addUserToGroup(connection);

            // commit transaction
            connection.commit();
            System.out.println("Transaction Commit!");

        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            System.out.println("Transaction Rollback!");
        }

        // turn on auto commit
        connection.setAutoCommit(true);

        // Step 6: Close connection
        connection.close();
    }

    private static void createGroup(Connection connection) throws SQLException {
        // Step 3: Create a statement object
        String sql = "INSERT INTO `Group` 		(`name` ,	`author_ID`	)"
                + "VALUE					(?		,		? 	 	)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // input from scanner
        String groupName = ".NET Senior3";
        short authorId = 3;

        // set parameter
        preparedStatement.setString(1, groupName);
        preparedStatement.setShort(2, authorId);

        // Step 4: Execute SQL query
        int effectedRecordAmount = preparedStatement.executeUpdate();

        // Step 5: Handling Result Set
        System.out.println("Effected Record Amount (Create Group): " + effectedRecordAmount);
    }

    private static void createUser(Connection connection) throws SQLException {
        // Step 3: Create a statement object
        String sql = "INSERT INTO `User` 	(`username`	,	`email`	,	`password`	,`firstName`,	`lastName`	,	`gender`	,`date_Of_Birth` , `address`, `phone` 	, `role`, `status`	)"
                + "VALUE				(	?	   	,	?  		, 		?		,	?		,		?		,		?		,		?		 ,		?	,	?		,	?	,	?		)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // input from scanner
        String username = "trong.vti.hayquen", email = "hungnguyen23@gmail.com", password = "123456", firstName = "Phạm",
                lastName = "Quang Hưng", gender = "M", dateOfBirth = "1999-02-02", address = "Hà Nội",
                phone = "03922225475", role = "EMPLOYEE";
        int status = 0;

        // set parameter
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, password);
        preparedStatement.setString(4, firstName);
        preparedStatement.setString(5, lastName);
        preparedStatement.setString(6, gender);
        preparedStatement.setString(7, dateOfBirth);
        preparedStatement.setString(8, address);
        preparedStatement.setString(9, phone);
        preparedStatement.setString(10, role);
        preparedStatement.setInt(11, status);

        // Step 4: Execute SQL query
        int effectedRecordAmount = preparedStatement.executeUpdate();

        // Step 5: Handling Result Set
        System.out.println("Effected Record Amount (Create User): " + effectedRecordAmount);
    }

    private static void addUserToGroup(Connection connection) throws SQLException {
        // Step 3: Create a statement object
        String sql = "INSERT INTO `User_Group` 		(`group_id` ,	`user_id`	)"
                + "VALUE						(	?		,		? 		)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        // input from scanner
        short group_id = 4;
        short user_id = 100;

        // set parameter
        preparedStatement.setShort(1, group_id);
        preparedStatement.setShort(2, user_id);

        // Step 4: Execute SQL query
        int effectedRecordAmount = preparedStatement.executeUpdate();

        // Step 5: Handling Result Set
        System.out.println("Effected Record Amount (Add UserTo Group): " + effectedRecordAmount);
    }
}
