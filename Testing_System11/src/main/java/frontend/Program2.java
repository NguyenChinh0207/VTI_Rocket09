package frontend;

import backend.presentationlayer.AccountController;
import entity.Account;
import utils.ScannerUtils;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Program2 {
    private static AccountController accountController;
    public static void main(String[] args) throws Exception {
        accountController = new AccountController();

        int choose = 0;
        do{
            loadMenu();
            choose = ScannerUtils.inputInt("Please input is int! Please input again:");

            switch (choose){
                case 1:
                    System.out.println("List Account:");
                    getListAccount();
                    break;
                case 2:
                    System.out.println("Get Account by ID:");
                    getAccountByID();
                    break;
                case 3:
                    System.out.println("Tạo Account:");
                    createAccount();
                    break;
                case 4:
                    System.out.println("Sửa Account:");
                    updateAccount();
                    break;
                case 5:
                    System.out.println("Xóa Account:");
                    deleteAccount();
                    break;
                case 6:
                    System.out.println("Thoát chương trình");
                    break;
                default:
                    System.out.println("Input wrong! Please input 1->6 again! ");
            }

        }while(choose != 6);
    }

    private static void deleteAccount() throws Exception {
        System.out.println("Nhập id cần xóa: ");
        int id = ScannerUtils.inputInt("Please input is int! Please input again:\"");

        accountController.deleteAccount(id);
    }

    private static void updateAccount() throws Exception {
        System.out.println("Nhập id cần update: ");
        int id = ScannerUtils.inputInt("Please input is int! Please input again:\"");

        System.out.println("Nhập user name: ");
        String username = ScannerUtils.inputString("Please input user name as String !");

        accountController.updateAccountByID(id, username);

    }

    private static void createAccount() throws Exception {
        System.out.println("Nhập email: ");
        String email = ScannerUtils.inputString("Please input email as String!");

        System.out.println("Nhập username: ");
        String username = ScannerUtils.inputString("Please input username as String!");

        System.out.println("Nhập full name: ");
        String fullName = ScannerUtils.inputString("Please input full name as String!");

        System.out.println("Nhập date: ");
        LocalDate createdate = ScannerUtils.inputDate("Please input createDate as dd/mm/yyyy!");

        accountController.createAccount(email,username, fullName,createdate);

    }

    private static void getAccountByID() throws Exception {
        System.out.println("Nhập id: ");
        int id = ScannerUtils.inputInt("Please input is int! Please input again:");
        Account account = accountController.getAccountByID(id);
        System.out.println(account);

    }

    private static void getListAccount() throws SQLException, ClassNotFoundException {
        List<Account> accounts = accountController.getListAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }

    public static void loadMenu(){
        System.out.println("---------------");
        System.out.println("1 - Hiển thị danh sách Account");
        System.out.println("2 - Tìm kiếm Account theo id");
        System.out.println("3 - Tạo Account ");
        System.out.println("4 - Update Account");
        System.out.println("5 - Xóa Account");
        System.out.println("6 - Exit");
        System.out.println("---------------");
        System.out.println("Your choose:");
    }

}
