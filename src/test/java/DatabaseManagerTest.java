import com.example.eindopdracht.AndereSchermen.DatabaseManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseManagerTest {

    @Test
    public void testCorrecteInloggegevens() {
        String gebruikersnaam = "admin";  // Vervang dit met een bestaande gebruiker in jouw database
        String wachtwoord = "admin123";   // En het bijbehorende wachtwoord

        boolean resultaat = DatabaseManager.authenticateUser(gebruikersnaam, wachtwoord);

        Assertions.assertTrue(resultaat, "Inloggen met correcte gegevens moet slagen");
    }

    @Test
    public void testFouteInloggegevens() {
        String gebruikersnaam = "verkeerd";
        String wachtwoord = "foutwachtwoord";

        boolean resultaat = DatabaseManager.authenticateUser(gebruikersnaam, wachtwoord);

        Assertions.assertFalse(resultaat, "Inloggen met foute gegevens moet falen");
    }
}
