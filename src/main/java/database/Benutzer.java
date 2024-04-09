package database;

import javax.persistence.*;

@Entity
@Table(name = "Benutzer")
public class Benutzer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BenutzerID")
    private int benutzerID;
    @Column(name = "Vorname")
    private String vorname;
    @Column(name = "Nachname")
    private String nachname;
    @Column(name="Benutzername")
    private String benutzername;
    @Column(name = "Email")
    private String email;
    @Column(name = "Passwort")
    private String passwort;
    @Column(name = "Geburtsdatum")
    private String geburtsdatum;
    @Column(name = "Profilbild")
    private String profilbild;

    public Benutzer(String vorname, String nachname, String benutzername,String email, String passwort, String geburtsdatum, String profilbild) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.benutzername = benutzername;
        this.email = email;
        this.passwort = passwort;
        this.geburtsdatum = geburtsdatum;
        this.profilbild = profilbild;
    }

    public int getBenutzerID() {
        return benutzerID;
    }
    public void setBenutzerID(int benutzerID) {
        this.benutzerID = benutzerID;
    }
    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public String getNachname() {
        return nachname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswort() {
        return passwort;
    }
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    public String getGeburtsdatum() {
        return geburtsdatum;
    }
    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }
    public String getProfilbild() {
        return profilbild;
    }
    public void setProfilbild(String profilbild) {
        this.profilbild = profilbild;
    }

}

