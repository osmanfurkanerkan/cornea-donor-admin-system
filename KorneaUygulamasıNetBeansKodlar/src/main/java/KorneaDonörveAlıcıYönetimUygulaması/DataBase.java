package KorneaDonörveAlıcıYönetimUygulaması;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    private static final String URL = "jdbc:sqlite:cornea.db";
    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("SQL Bağlantı Hatası: " + e.getMessage());
            return null;
        }
    }
}
