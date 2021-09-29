package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/preproject";
    private static final String USER = "root";
    private static final String PASSWORD = "qwerty123";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Не удалось установить соединение с БД!");
            e.printStackTrace();
        }
        return null;
    }
}
