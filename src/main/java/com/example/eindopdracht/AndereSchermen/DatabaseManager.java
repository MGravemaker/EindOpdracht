package com.example.eindopdracht.AndereSchermen;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.sql.DriverManager.getConnection;


public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/gegevensmoc"; // Database URL
    private static final String USER = "root"; // Database username
    private static final String PASSWORD = ""; // Database password

    // Method to authenticate user
    public static boolean authenticateUser(String gebruikersnaam, String wachtwoord) {
        String query = "SELECT * FROM inloggegevens WHERE gebruikersnaam = ? AND wachtwoord = ?";

        try (Connection connectie = getConnection(URL, USER, PASSWORD);
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

        try (Connection connectie = getConnection(URL, USER, PASSWORD);
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

        try (Connection connectie = getConnection(URL, USER, PASSWORD);
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

        try (Connection connectie = getConnection(URL, USER, PASSWORD);
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

        try (Connection connectie = getConnection(URL, USER, PASSWORD);
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

        try (Connection conn = getConnection(URL, USER, PASSWORD);
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

        try (Connection conn = getConnection(URL, USER, PASSWORD);
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

        try (Connection conn = getConnection(URL, USER, PASSWORD);
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

        try (Connection conn = getConnection(URL, USER, PASSWORD);
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

        try (Connection conn = getConnection(URL, USER, PASSWORD);
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

        try (Connection conn = getConnection(URL, USER, PASSWORD);
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

        try (Connection conn = getConnection(URL, USER, PASSWORD);
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

    public static boolean verwijderLid(String voornaam, String achternaam) {
        String query = "DELETE FROM Lidgegevens WHERE Voornaam = ? AND Achternaam = ?";
        try (Connection connectie = getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connectie.prepareStatement(query)) {

            statement.setString(1, voornaam);
            statement.setString(2, achternaam);
            int rowsDeleted = statement.executeUpdate();

            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static class Lid {
        public String voornaam;
        public String achternaam;
        public String teamnaam;
        public String rol;
        public String geboortedatum;
        public String geslacht;
        public String email;
        public String telefoonnummer;
        public String TeamID;
        public int LidID;

        public Lid(String voornaam, String achternaam, String TeamID, String rol, String geboortedatum,
                   String geslacht, String email, String telefoonnummer, int LidID) {
            this.voornaam = voornaam;
            this.achternaam = achternaam;
            this.TeamID = TeamID;
            this.rol = rol;
            this.geboortedatum = geboortedatum;
            this.geslacht = geslacht;
            this.email = email;
            this.telefoonnummer = telefoonnummer;
            this.LidID = LidID;
        }
    }

    // Fetch all leden (members) from database
    public static List<Lid> getLeden() {
        List<Lid> ledenLijst = new ArrayList<>();
        String query = "SELECT Voornaam, Achternaam, TeamID, Rol, Geboortedatum, Geslacht, Email, Telefoonnummer, LidID  FROM Lidgegevens";

        try (Connection connectie = getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connectie.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String voornaam = resultSet.getString("Voornaam");
                String achternaam = resultSet.getString("Achternaam");
                String TeamID = resultSet.getString("TeamID");
                String rol = resultSet.getString("Rol");
                String geboortedatum = resultSet.getString("Geboortedatum");
                String geslacht = resultSet.getString("Geslacht");
                String email = resultSet.getString("Email");
                String telefoonnummer = resultSet.getString("Telefoonnummer");
                int LidID = resultSet.getInt("LidID");

                ledenLijst.add(new Lid(voornaam, achternaam, TeamID, rol, geboortedatum, geslacht, email, telefoonnummer, LidID));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ledenLijst;
    }

    public static boolean deleteLid(int lidID) {
        String query = "DELETE FROM lidgegevens WHERE LidID = ?";

        try (Connection conn = getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, lidID);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0; // True als een rij is verwijderd

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean updateLid(Lid lid) {
        String query = "UPDATE lidgegevens SET voornaam=?, achternaam=?, email=?, telefoonnummer=?, geboortedatum=?, geslacht=?, TeamID=?, rol=? WHERE LidID=?";
        try (Connection conn = getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, lid.voornaam);
            pstmt.setString(2, lid.achternaam);
            pstmt.setString(3, lid.email);
            pstmt.setString(4, lid.telefoonnummer);
            pstmt.setString(5, lid.geboortedatum);
            pstmt.setString(6, lid.geslacht);
            pstmt.setString(7, lid.TeamID);
            pstmt.setString(8, lid.rol);
            pstmt.setInt(9, lid.LidID);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public enum Activiteit {
        ACTIEF, NONACTIEF
    }

    public static class Team {
        public int teamID;
        public String teamNaam;
        public Activiteit activiteit;

        // Enum with Actief or Nonactief

        public Team(int teamID, String teamNaam, Activiteit activiteit) {
            this.teamID = teamID;
            this.teamNaam = teamNaam;
            this.activiteit = activiteit;

        }
    }

    public static List<Team> getTeams() {
        List<Team> teamLijst = new ArrayList<>();
        String query = "SELECT TeamID, TeamNaam, Activiteit FROM teamgegevens";  // Use the view

        try (Connection connectie = getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connectie.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int teamID = resultSet.getInt("TeamID");
                String teamNaam = resultSet.getString("TeamNaam");

                String activiteitStr = resultSet.getString("Activiteit").toUpperCase();
                Activiteit activiteit = Activiteit.valueOf(activiteitStr);


                teamLijst.add(new Team(teamID, teamNaam, activiteit));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teamLijst;
    }



    public static boolean updateTeam(Team team) {
        String query = "UPDATE Teamgegevens SET TeamNaam=?, Activiteit=? WHERE TeamID=?";
        try (Connection conn = getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, team.teamNaam);
            pstmt.setString(2, team.activiteit.name());  // Convert enum to String
            pstmt.setInt(3, team.teamID);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteTeam(int teamID) {
        String query = "DELETE FROM Teamgegevens WHERE TeamID = ?";

        try (Connection conn = getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, teamID);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0; // Return true if a row is deleted

        } catch (SQLException e) {
            e.printStackTrace();
            return false;


        }
    }
    public static class Training {
        public int TeamID;
        public String TrainingDatumTijd;
        public int TrainingID;  // Now a non-nullable int
        public String Veld;


        // Enum with Actief or Nonactief

        public Training(int TeamID, String TrainingDatumTijd, int TrainingID, String Veld ) {
            this.TeamID = TeamID;
            this.TrainingDatumTijd = TrainingDatumTijd;
            this.TrainingID = TrainingID;
            this.Veld = Veld;
        }
    }

    public static List<Training> getTrainingen() {
        List<Training> TrainingLijst = new ArrayList<>();
        String query = "SELECT TeamID, TrainingDatumTijd, TrainingID, Veld FROM traininggegevens";  // Use the view

        try (Connection connectie = getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connectie.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int TeamID = resultSet.getInt("TeamID");
                String TrainingDatumTijd = String.valueOf(resultSet.getString("TrainingDatumTijd"));
                int TrainingID = resultSet.getInt("TrainingID");
                String Veld = resultSet.getString("Veld"); // Fetching from the view

                TrainingLijst.add(new Training(TeamID, TrainingDatumTijd, TrainingID, Veld));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return TrainingLijst;
    }

    public static boolean updateTraining(Training training) {
        // We use the first TrainingID to set the new value, and the second one in the WHERE clause to identify the record
        String query = "UPDATE traininggegevens SET TeamID=?, TrainingID=?, TrainingDatumTijd=?, Veld=? WHERE TrainingID=?";
        try (Connection conn = getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, training.TeamID);                    // Update TeamID
            pstmt.setInt(2, training.TrainingID);                // Update TrainingID (if it's changing)
            pstmt.setString(3, training.TrainingDatumTijd);      // Update TrainingDatumTijd (Date/Time)
            pstmt.setString(4, training.Veld);                   // Update Veld (Location or other data)
            pstmt.setInt(5, training.TrainingID);                // Use the current TrainingID to identify the record to update

            return pstmt.executeUpdate() > 0;  // Return true if at least 1 row is updated
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




    public static boolean deleteTraining (int TrainingID) {
        String query = "DELETE FROM traininggegevens WHERE TrainingID = ?";

        try (Connection conn = getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, TrainingID);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0; // Return true if a row is deleted

        } catch (SQLException e) {
            e.printStackTrace();
            return false; 


        }
    }
    public static class Wedstrijd {
        public int WedstrijdID;
        public int TeamID;
        public String WedstrijdDatumTijd;
        public String Team2Naam;  // Now a non-nullable int
        public String Veld;


        // Enum with Actief or Nonactief

        public Wedstrijd(int TeamID, String WedstrijdDatumTijd, int WedstrijdID, String Veld, String Team2Naam ) {
            this.TeamID = TeamID;
            this.WedstrijdDatumTijd = WedstrijdDatumTijd;
            this.WedstrijdID = WedstrijdID;
            this.Team2Naam = Team2Naam;
            this.Veld = Veld;
        }
    }

    public static List<Wedstrijd> getWedstrijden() {
        List<Wedstrijd> WedstrijdLijst = new ArrayList<>();
        String query = "SELECT TeamID, WedstrijdDatumTijd, WedstrijdID, Veld, Team2Naam FROM wedstrijdgegevens";  // Use the view

        try (Connection connectie = getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connectie.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int TeamID = resultSet.getInt("TeamID");
                String WedstrijdDatumTijd = resultSet.getString("WedstrijdDatumTijd");
                int WedstrijdID = resultSet.getInt("WedstrijdID");
                String Team2Naam = resultSet.getString("Team2Naam");
                String Veld = resultSet.getString("Veld"); // Fetching from the view

                WedstrijdLijst.add(new Wedstrijd(TeamID, WedstrijdDatumTijd, WedstrijdID, Veld, Team2Naam));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return WedstrijdLijst;
    }



    public static boolean updateWedstrijd(Wedstrijd wedstrijd) {
        String query = "UPDATE wedstrijdgegevens SET TeamID=?, WedstrijdID=?, WedstrijdDatumTijd=?, Veld=?, Team2Naam=? WHERE WedstrijdID=?";
        try (Connection conn = getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, wedstrijd.TeamID);
            pstmt.setInt(2, wedstrijd.WedstrijdID);
            pstmt.setString(3, wedstrijd.WedstrijdDatumTijd);  // Convert enum to String
            pstmt.setString(4, wedstrijd.Veld);
            pstmt.setString(5, wedstrijd.Team2Naam);
            pstmt.setInt(6, wedstrijd.WedstrijdID);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteWedstrijd (int WedstrijdID) {
        String query = "DELETE FROM wedstrijdgegevens WHERE WedstrijdID = ?";

        try (Connection conn = getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, WedstrijdID);
            int rowsAffected = stmt.executeUpdate();

            return rowsAffected > 0; // Return true if a row is deleted

        } catch (SQLException e) {
            e.printStackTrace();
            return false;


        }
    }
}
















