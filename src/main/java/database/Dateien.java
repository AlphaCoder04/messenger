package database;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Dateien")
public class Dateien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DateiID")
    private int dateiID;
    @Column(name = "Dateiname")
    private String dateiname;
    @Column(name = "Dateityp")
    private String dateityp;
    @Column(name = "Groesse")
    private int groesse;
    @Column(name = "HochgeladenVon")
    private int hochgeladenVon;
    @Column(name = "HochladeDatum")
    private Timestamp hochladeDatum;

    public Dateien(String dateiname, String dateityp, int groesse, int hochgeladenVon, Timestamp hochladeDatum) {
        this.dateiname = dateiname;
        this.dateityp = dateityp;
        this.groesse = groesse;
        this.hochgeladenVon = hochgeladenVon;
        this.hochladeDatum = hochladeDatum;
    }
    public int getDateiID() {
        return dateiID;
    }
    public void setDateiID(int dateiID) {
        this.dateiID = dateiID;
    }
    public String getDateiname() {
        return dateiname;
    }
    public void setDateiname(String dateiname) {
        this.dateiname = dateiname;
    }
    public String getDateityp() {
        return dateityp;
    }
    public void setDateityp(String dateityp) {
        this.dateityp = dateityp;
    }
    public int getGroesse() {
        return groesse;
    }
    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }
    public int getHochgeladenVon() {
        return hochgeladenVon;
    }
    public void setHochgeladenVon(int hochgeladenVon) {
        this.hochgeladenVon = hochgeladenVon;
    }
    public Timestamp getHochladeDatum() {
        return hochladeDatum;
    }
    public void setHochladeDatum(Timestamp hochladeDatum) {
        this.hochladeDatum = hochladeDatum;
    }
}
