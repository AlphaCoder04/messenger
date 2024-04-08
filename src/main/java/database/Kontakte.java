package database;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "Kontakte")

public class Kontakte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KontaktID")
    private int kontaktID;
    @Column(name = "BenutzerID")
    private int benutzerID;
    @Column(name = "Kontaktname")
    private String kontaktName;
    @Column(name = "Status")
    private String status;
    @Column(name = "ZuletztOnline")
    private Timestamp zuletztOnline;

    public Kontakte(int benutzerID, String  kontaktName, String status, Timestamp zuletztOnline) {
        this.benutzerID = benutzerID;
        this.kontaktName = kontaktName;
        this.status = status;
        this.zuletztOnline = zuletztOnline;
    }

    public int getKontaktID() {
        return kontaktID;
    }
    public void setKontaktID(int kontaktID) {
        this.kontaktID = kontaktID;
    }
    public int getBenutzerID() {
        return benutzerID;
    }
    public void setBenutzerID(int benutzerID) {
        this.benutzerID = benutzerID;
    }
    public String getKontaktName() {
        return kontaktName;
    }
    public void setKontaktName(String kontaktName) {
        this.kontaktName = kontaktName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Timestamp getZuletztOnline() {
        return zuletztOnline;
    }
    public void setZuletztOnline(Timestamp zuletztOnline) {
        this.zuletztOnline = zuletztOnline;
    }
}
