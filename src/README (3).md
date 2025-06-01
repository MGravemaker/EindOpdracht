# JavaFX Clubbeheer Applicatie

Deze JavaFX desktopapplicatie is ontwikkeld voor het beheren van een sportclub. Gebruikers kunnen leden, teams, wedstrijden en trainingen toevoegen, bewerken en verwijderen via een gebruiksvriendelijke interface. De applicatie gebruikt JavaFX zonder FXML en maakt verbinding met een relationele database (MySQL).

## Functionaliteiten

- Ledenbeheer (CRUD)
- Teambeheer (CRUD)
- Wedstrijdbeheer (CRUD)
- Trainingbeheer (CRUD)
- Toevoegschermen voor elk type entiteit
- Navigatiestructuur met consistente stijl
- Refresh-knoppen voor real-time updates

## Installatie-instructies

### Vereisten

- Java 17 of hoger
- Maven of een IDE zoals IntelliJ IDEA
- MySQL Server (of compatibele relationele database)
- Git

### Installatiestappen

1. Clone de repository:
   ```bash
   git clone https://github.com/jouwgebruikersnaam/clubbeheer.git
   ```

2. Open het project in IntelliJ IDEA of een andere Java IDE.

3. Configureer je databaseverbinding in `DatabaseManager.java`:
   ```java
   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubdb", "root", "jouwwachtwoord");
   ```

4. Zorg ervoor dat je een MySQL-database hebt met de volgende tabellen: `leden`, `teams`, `trainingen`, `wedstrijden`.

5. Run het project via `Main.java` of exporteer het naar een runnable `.jar`.

## Configuratie

Alle database-instellingen zijn gedefinieerd in `DatabaseManager.java`. Hier kun je URL, gebruikersnaam en wachtwoord aanpassen.

Voorbeeld:
```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/clubdb";
private static final String DB_USER = "admin";
private static final String DB_PASSWORD = "wachtwoord";
```

## Gebruik

1. Start de applicatie.
2. Navigeer via de knoppen naar Leden, Teams, Wedstrijden of Trainingen.
3. Selecteer een rij om gegevens te bewerken of te verwijderen.
4. Klik op ‘Toevoegen’ om een nieuw item aan te maken.
5. Gebruik de refresh-knop om de data te vernieuwen.

## Roadmap / Toekomstige uitbreidingen

- CRUD-functionaliteit voor alle entiteiten
- Toevoegschermen voor elk type data
- Inlogfunctionaliteit met gebruikersrollen
- Validatie en foutmeldingen bij foutieve invoer
- Mogelijkheid tot exporteren van overzichten naar PDF
- Verbetering van de lay-out en foutafhandeling

## Auteur

Mathijs Gravemaker

## Versiebeheer

Alle wijzigingen worden bijgehouden via GitHub. De commitgeschiedenis toont de volledige voortgang en structuur van het project.
