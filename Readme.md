# Moc 17 Systeem beheer applicatie 

## Over dit project
Dit project is een applicatie voor het beheren van leden, teams, trainingen en wedstrijden. Je kunt gegevens toevoegen, bewerken, verwijderen en herladen via een overzichtelijke interface.

---

## Installatiehandleiding

### 1. Importeren van de SQL-database
Om de applicatie correct te laten werken, moet je de database importeren:

1. Open phpMyAdmin of een andere MySQL-client.
2. Maak een nieuwe database aan.
3. Importeer het SQL-bestand (`database.sql`).
4. Controleer of alle tabellen correct zijn aangemaakt.

---

## Inloggen
1. Start de applicatie.
2. Voer de volgende gegevens in op het inlogscherm:
   - Gebruikersnaam: `admin`
   - Wachtwoord: `wachtwoord`
3. Klik op **Inloggen** om toegang te krijgen.

---

## Navigatie
Na het inloggen kun je navigeren via het menu:

- **LedenBeheer**
  - Leden beheren
  - Teams beheren
- **VeldenBeheer**
  - Trainingen beheren
  - Wedstrijden beheren

Klik op een van deze opties om naar de gewenste pagina te gaan.

---

## Gegevens toevoegen
1. Op elke beheerpagina zie je linksonder een **Toevoegen**-knop.
2. Klik op deze knop om een nieuw gegevensobject toe te voegen.
3. Vul alle vereiste velden in.
4. Klik op **Opslaan**.
5. Je keert terug naar de vorige pagina en de nieuwe data verschijnt in de lijst.

---

## Gegevens bewerken
1. Klik op een rij in de tabel aan de rechterkant.
2. De gegevens verschijnen in een bewerkbaar veld.
3. Pas de informatie aan.
4. Klik op **Opslaan** om de wijzigingen door te voeren.

---

## Gegevens verwijderen
1. Naast elke rij staat een **Verwijder**-knop.
2. Klik hierop om de gegevens definitief uit het systeem te verwijderen.

---

## Gegevens vernieuwen
- Rechts boven de datatabel bevindt zich een **Refresh**-knop.
- Klik hierop om de meest recente gegevens opnieuw in te laden.
- Dit is handig als je net een wijziging hebt doorgevoerd en wilt controleren of deze correct is opgeslagen.

---

## Samenvatting van functionaliteiten
- Inloggen met admin-gegevens  
- Leden, teams, trainingen en wedstrijden beheren  
- Nieuwe gegevens toevoegen  
- Bestaande gegevens aanpassen  
- Gegevens verwijderen uit het systeem  
- Data verversen voor de laatste updates  

---

## Extra informatie
- Zorg ervoor dat je de juiste databaseconfiguratie hebt ingesteld in het project.
- Indien je problemen ondervindt, controleer dan of je database goed is verbonden.




