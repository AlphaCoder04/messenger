-- Benutzer-Tabelle 
CREATE TABLE Benutzer (
BenutzerID INT PRIMARY KEY auto_increment, Vorname VARCHAR(50),
Nachname VARCHAR(50), Benutzername VARCHAR(50) UNIQUE, Email VARCHAR(100) UNIQUE, Passwort VARCHAR(100), Geburtsdatum DATE,
Profilbild VARCHAR(255) );
-- Kontakte-Tabelle 
CREATE TABLE Kontakte (
KontaktID INT PRIMARY KEY auto_increment,
BenutzerID INT,
Kontaktname VARCHAR(50),
Status VARCHAR(20),
ZuletztOnline TIMESTAMP,
FOREIGN KEY (BenutzerID) REFERENCES Benutzer(BenutzerID)
);
-- Gruppen-Tabelle 
CREATE TABLE Gruppen (
GruppenID INT PRIMARY KEY auto_increment, Gruppenname VARCHAR(50), Gruppenbild VARCHAR(255), Erstellungsdatum DATE
);
-- Chats-Tabelle 
CREATE TABLE Chats (
ChatID INT PRIMARY KEY auto_increment,
Typ VARCHAR(20),
Erstellungsdatum TIMESTAMP );
-- Nachrichten-Tabelle 
CREATE TABLE Nachrichten (
NachrichtenID INT PRIMARY KEY auto_increment, ChatID INT,
AbsenderID INT, Nachrichteninhalt TEXT, Sendezeit TIMESTAMP,
FOREIGN KEY (ChatID) REFERENCES Chats(ChatID),
FOREIGN KEY (AbsenderID) REFERENCES Benutzer(BenutzerID) );
-- Anrufe-Tabelle 
CREATE TABLE Anrufe (
AnrufID INT PRIMARY KEY auto_increment, AnruferID INT, EmpfaengerID INT, Anrufzeit TIMESTAMP, Dauer INT,
Anrufart VARCHAR(20),
FOREIGN KEY (AnruferID) REFERENCES Benutzer(BenutzerID), FOREIGN KEY (EmpfaengerID) REFERENCES Benutzer(BenutzerID)
);
-- Videoanrufe-Tabelle 
CREATE TABLE Videoanrufe (
VideoanrufID INT PRIMARY KEY auto_increment,
AnrufID INT,
VideostreamURL VARCHAR(255),
KameraAkZviert BOOLEAN,
MikrofonAkZviert BOOLEAN,
FOREIGN KEY (AnrufID) REFERENCES Anrufe(AnrufID)

);
-- Dateien-Tabelle 
CREATE TABLE Dateien (
DateiID INT PRIMARY KEY,
Dateiname VARCHAR(100),
Dateityp VARCHAR(50),
Groesse INT,
HochgeladenVon INT,
Hochladedatum TIMESTAMP,
FOREIGN KEY (HochgeladenVon) REFERENCES Benutzer(BenutzerID)
);
