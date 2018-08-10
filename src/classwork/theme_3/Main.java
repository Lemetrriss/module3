package classwork.theme_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection dbConnectio = null;
        try {
            dbConnectio = DriverManager.getConnection(" ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}