package com.example.eindopdracht.AndereSchermen;

import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/gegevensmoc"; // Database URL
    private static final String USER = "root"; // Database username
    private static final String PASSWORD = ""; // Database password

    // Method to authenticate user
    public static boolean authenticateUser(String gebruikersnaam, String wachtwoord) {
        String query = "SELECT * FROM inloggegevens WHERE gebruikersnaam = ? AND wachtwoord = ?";

        try (Connection connectie = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connectie.prepareStatement(query)) {

            statement.setString(1, gebruikersnaam);
            statement.setString(2, wachtwoord);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Returns true if user exists

        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
}
