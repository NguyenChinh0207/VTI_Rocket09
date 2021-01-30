import java.sql.*;

public class Programe {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/testingsystem";
        String username = "root";
        String password = "nchinh407@gmail";
        //step 2: create connection
        Connection connection = DriverManager.getConnection(url, username, password);
        //check connection thành công hay chưa.
        System.out.println("Connect Success!");
        //step 3: make statement
//        Statement statement = connection.createStatement();

        //step 4: execute sql
//        String sql = "SELECT * FROM user";


        String sql = "INSERT INTO `Group` (`name` , `author_ID` ) " +
                    "VALUE (?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        String name = "PhP Developer";
        int authorId = 12;

        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, authorId);

        int numberOfRowsAffected = preparedStatement.executeUpdate();


        System.out.println("Số dòng bị thay đổi: " + numberOfRowsAffected);
//        while (resultSet.next()){
//            System.out.println(resultSet.getInt(1));
//            System.out.println(resultSet.getString("username"));
//            System.out.println(resultSet.getString("phone"));
//            System.out.println("------------------");
//        }
    }
}
