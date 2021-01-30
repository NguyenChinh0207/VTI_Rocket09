package frontend;

import backend.presentationlayer.UserController;
import entity.User;
import utils.ScannerUtils;

import java.sql.SQLException;
import java.util.List;

import static java.lang.Thread.sleep;


public class Program {
    private static UserController userController;

    public static void loadMenu() {
        System.out.println("---------------");
        System.out.println("1 - In all User");
        System.out.println("2 - in ra tất cả các employee & Manager trong project theo IDproject");
        System.out.println("3 - In all Manager của các Project");
        System.out.println("4 - login");
        System.out.println("5 - Exit");
        System.out.println("---------------");
        System.out.println("Your choose:");
    }

    public static void main(String[] args) throws Exception {
        userController = new UserController();
        int choose = 0;
        do {
            loadMenu();
            choose = ScannerUtils.inputInt("Please input is int! Please input 1->4 again:");
            switch (choose) {
                case 1:
                    getListUser();
                    break;
                case 2:
                    getEmployeeManagerByIDProject();
                    break;
                case 3:
                    getListManagerOfProject();
                    break;
                case 4:
                    login();
                    break;
                case 5:
                    System.out.println("Exit Program!");
                    return;
                default:
                    System.out.println("Input wrong! Please input 1->4 again! ");
            }

        } while (choose != 5);

    }

    public static void getListUser() throws SQLException, ClassNotFoundException {

        List<User> users = userController.getListUser();
        System.out.printf("%-15s %-25s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password", "Role");
        for (User user : users) {
            System.out.printf("%-15s %-25s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(),
                    user.getPassWord(), user.getRole());
        }


    }

    public static void getEmployeeManagerByIDProject() throws Exception {
        while (true) {
            System.out.print("Please id input: ");
            int id = ScannerUtils.inputID("Please input id as int >0, please input again!!");

            if (userController.isProjectExists(id)) {
                List<User> users = userController.getEmployeeManagerByIDProject(id);
                System.out.printf("%-15s %-25s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password", "Role");
                for (User user : users) {
                    System.out.printf("%-15s %-25s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(), user.getPassWord(), user.getRole());
                }
                break;
            } else {
                System.err.println("ID input is not exists! Please input again! ");
            }
        }

    }

    public static void getListManagerOfProject() throws SQLException, ClassNotFoundException {

        List<User> users = userController.getListManagerOfProject();
        System.out.printf("%-15s %-25s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password", "Role");
        for (User user : users) {
            System.out.printf("%-15s %-25s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullName(),
                    user.getPassWord(), user.getRole());
        }


    }
    public static boolean checkLogin(String email, String passWord) throws SQLException {
        List<User> users = userController.getListUser();
        for (User user : users) {
            if (email.equals(user.getEmail()) && passWord.equals(user.getPassWord())) {
                return true;
            }
        }
        return false;
    }
    public static void login() throws ClassNotFoundException, SQLException, InterruptedException {
        while (true){
            System.out.print("Email: ");
            String email = ScannerUtils.inputEmail("Email is not format.");

            System.out.print("Password: ");
            String password = ScannerUtils.inputPassWord("Password must length from 6-> 12 \n" +
                    "characters and at least 1 character to Uppercase!");
            if(checkLogin(email,password))
            {
                System.out.println("Login success!!");
                break;
            }
            else
                System.err.println("email or password is not correct !!");
                sleep(1000);

        }
    }


}
