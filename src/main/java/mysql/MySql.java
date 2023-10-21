package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySql {
    public static void insertSql(String s1,String s2,String s3){
        try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/sys";
            String user = "root";
            String password = "haslo";

            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Połączono z bazą danych MySQL - insert");

            // Polecenie INSERT do dodania danych do tabeli "user"
            String insertSQL = "INSERT INTO user (imie, nazwisko, haslo) VALUES (?, ?, ?)";

            // Tworzenie obiektu PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

            // Ustawienie wartości parametrów
            preparedStatement.setString(1, s1);
            preparedStatement.setString(2, s2);
            preparedStatement.setString(3, s3);

            // Wykonanie polecenia INSERT
            int affectedRows = preparedStatement.executeUpdate();


            if (affectedRows > 0) {
                System.out.println("Dodano nowego użytkownika do tabeli.");
            } else {
                System.out.println("Nie udało się dodać użytkownika.");
            }

            // Zamykanie PreparedStatement i Connection
            preparedStatement.close();
            connection.close();
            System.out.println("Rozłączono z bazą danych MySQL - insert");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
