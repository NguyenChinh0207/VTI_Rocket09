package frontend;

import backend.Transaction;

import java.io.IOException;
import java.sql.SQLException;

public class Transaction_Program {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Transaction transaction = new Transaction();
        transaction.Question1();

    }
}
