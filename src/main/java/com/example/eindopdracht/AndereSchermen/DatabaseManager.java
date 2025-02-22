package com.example.eindopdracht.AndereSchermen;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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


    public static boolean insertLid(String voornaam, String achternaam, String email, String telefoonnummer,
                                    String geboortedatum, String geslacht, String team, String rol) {
        String query = "INSERT INTO LidGegevens (Voornaam, Achternaam, Email, Telefoonnummer, Geboortedatum, Geslacht, TeamID, Rol) " +
                "VALUES (?, ?, ?, ?, ?, ?, (SELECT TeamID FROM TeamGegevens WHERE TeamNaam = ?), ?)";

        try (Connection connectie = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connectie.prepareStatement(query)) {

            statement.setString(1, voornaam);
            statement.setString(2, achternaam);
            statement.setString(3, email);
            statement.setString(4, telefoonnummer);
            statement.setString(5, geboortedatum);
            statement.setString(6, geslacht);
            statement.setString(7, team);  // Finds TeamID by name
            statement.setString(8, rol);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0; // Returns true if insertion was successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean insertTeam(String teamNaam, String activiteit, Integer trainerLidId) {
        String query = "INSERT INTO TeamGegevens (TeamNaam, Activiteit, TrainerLidID) VALUES (?, ?, ?)";

        try (Connection connectie = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connectie.prepareStatement(query)) {

            statement.setString(1, teamNaam);
            statement.setString(2, activiteit);

            if (trainerLidId != null) {
                statement.setInt(3, trainerLidId);
            } else {
                statement.setNull(3, Types.INTEGER); // Allows "Geen trainer"
            }

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean insertTraining(int teamId, LocalDateTime trainingDateTime, int veld) {
        String query = "INSERT INTO TrainingGegevens (TeamID, TrainingDatumTijd, Veld) VALUES (?, ?, ?)";

        try (Connection connectie = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connectie.prepareStatement(query)) {

            statement.setInt(1, teamId); // TeamID
            statement.setTimestamp(2, Timestamp.valueOf(trainingDateTime)); // Convert LocalDateTime to Timestamp
            statement.setInt(3, veld); // Veld number

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean insertWedstrijd(int teamID, String team2Naam, LocalDateTime wedstrijdDatumTijd, int veld) {
        // SQL query to insert the match details into the database
        String query = "INSERT INTO WedstrijdGegevens (TeamID, Team2Naam, WedstrijdDatumTijd, Veld) VALUES (?, ?, ?, ?)";

        try (Connection connectie = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connectie.prepareStatement(query)) {

            // Set the values for each placeholder in the query
            statement.setInt(1, teamID);  // TeamID
            statement.setString(2, team2Naam);  // Team2Naam
            statement.setTimestamp(3, Timestamp.valueOf(wedstrijdDatumTijd));  // WedstrijdDatumTijd
            statement.setInt(4, veld);  // Veld

            // Execute the insert statement and check if any rows were inserted
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;  // Return true if insert was successful, false otherwise

        } catch (SQLException e) {
            e.printStackTrace();  // Print out any errors that occurred during the insertion
            return false;  // Return false if an error occurred
        }
    }





    //  public static boolean insertTraining(String training) {

  //  }

    public static List<String> getTeamNames() {
        List<String> teamNames = new ArrayList<>();

        String query = "SELECT TeamNaam FROM teamgegevens"; // Change 'teams' to your actual table name

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                teamNames.add(rs.getString("teamnaam")); // Assuming "teamnaam" is your column name
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return teamNames;
    }


    public static List<String> getLidnamen() {
        List<String> lidnamen = new ArrayList<>();
        String query = "SELECT CONCAT(voornaam, ' ', achternaam) AS lidnaam FROM lidgegevens";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                lidnamen.add(rs.getString("lidnaam"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lidnamen;
    }

    public static Integer getTeamIdByName(String teamNaam) {
        String query = "SELECT TeamID FROM TeamGegevens WHERE TeamNaam = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, teamNaam);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getInt("TeamID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if not found
    }

    public static void updateTeamForLid(String spelerNaam, int teamId) {
        String query = "UPDATE lidgegevens SET TeamID = ? WHERE CONCAT(voornaam, ' ', achternaam) = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, teamId);
            statement.setString(2, spelerNaam);
            statement.executeUpdate();
            System.out.println("Lid updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static List<String> getLedenByTeam(int teamId) {
        List<String> lidnamen = new ArrayList<>();
        String query = "SELECT CONCAT(voornaam, ' ', achternaam) AS lidnaam FROM lidgegevens WHERE team_id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, teamId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                lidnamen.add(rs.getString("lidnaam"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lidnamen;
    }

    public static List<String> getTrainerNames() {
        List<String> trainerNames = new ArrayList<>();
        String query = "SELECT CONCAT(Voornaam, ' ', Achternaam) AS TrainerNaam FROM lidgegevens WHERE Rol = 'Trainer'";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                trainerNames.add(rs.getString("TrainerNaam"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainerNames;
    }

    public static Integer getLidIdByName(String fullName) {
        String query = "SELECT LidID FROM lidgegevens WHERE CONCAT(Voornaam, ' ', Achternaam) = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, fullName);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getInt("LidID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if not found
    }




}







