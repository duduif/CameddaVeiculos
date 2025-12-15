package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

    private static final String URL = "jdbc:postgresql://dpg-d4vh64juibrs73d7qk9g-a.oregon-postgres.render.com:5432/camedda_veiculos";
    private static final String USER = "camedda_veiculos_user";
    private static final String PASSWORD = "fOwDIiDadEXOXPS9eSeywUjG5yxjaDnt";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar no banco: " + e.getMessage());
        }
    }
}
