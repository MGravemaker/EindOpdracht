# JavaFX Clubbeheer Applicatie

Deze JavaFX desktopapplicatie is gebouwd voor het beheren van een sportclub. Gebruikers kunnen leden, teams, wedstrijden en trainingen toevoegen, bewerken en verwijderen via een simpele interface. De app gebruikt JavaFX zonder FXML en maakt verbinding met een MySQL-database.

## Functionaliteiten

- Ledenbeheer (CRUD)
- Teambeheer (CRUD)
- Wedstrijdbeheer (CRUD)
- Trainingbeheer (CRUD)
- Toevoegschermen per entiteit
- Refresh-knoppen om data te vernieuwen
- Navigatie met vaste layout

## Installatie-instructies

### Vereisten

- Java 17 of hoger
- IntelliJ IDEA of andere IDE
- MySQL Server
- Git

### Installatiestappen

1. Clone het project:
   ```bash
   git clone https://github.com/jouwgebruikersnaam/clubbeheer.git
   ```

2. Open het project in IntelliJ IDEA.

3. Stel je databasegegevens in bij `DatabaseManager.java`:
   ```java
   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clubdb", "root", "jouwwachtwoord");
   ```

4. Zorg dat je de juiste tabellen hebt: `leden`, `teams`, `trainingen`, `wedstrijden`.

5. Start de applicatie via `Main.java` of exporteer naar `.jar`.

## Configuratie

Je vindt alle DB-instellingen in `DatabaseManager.java`:
```java
private static final String DB_URL = "jdbc:mysql://localhost:3306/clubdb";
private static final String DB_USER = "admin";
private static final String DB_PASSWORD = "wachtwoord";
```

## Gebruik

1. Start de app.
2. Kies een onderdeel (Leden, Teams, etc.).
3. Voeg toe, verwijder of bewerk items.
4. Gebruik ‘Refresh’ om data bij te werken.

## Implementatieplan

### Tijdlijn

| Fase | Beschrijving                          | Periode        |
|------|---------------------------------------|----------------|
| 1    | Setup DB + basisstructuur             | Week 1–2       |
| 2    | CRUD bouwen per entiteit              | Week 3         |
| 3    | UI verbeteren en testdata toevoegen   | Week 4         |
| 4    | Gebruikerstest + bugfixes             | Week 5         |
| 5    | Oplevering + laatste check            | Week 6         |

### Communicatiestrategie

- Wekelijkse updates aan begeleider
- Feedback verwerken via mail of mondeling overleg
- Belangrijke wijzigingen worden in GitHub commits en comments uitgelegd

### Evaluatiemethode

- Werktest op verschillende pc's met Java 17
- Controle of CRUD-operaties goed lopen
- Gebruikerstest met eindgebruiker uit doelgroep
- Feedback verwerken en laatste verbeteringen toepassen

## Roadmap (Toekomst)

- Inlogscherm + gebruikersrollen
- Validatie bij foutieve invoer
- Export naar PDF
- Verbeterde errorafhandeling
- Mogelijk cloud-sync

## Auteur

Mathijs Gravemaker

## Versiebeheer

Alle commits en voortgang staan op GitHub. Versiebeheer gebeurt via branches en pull requests.