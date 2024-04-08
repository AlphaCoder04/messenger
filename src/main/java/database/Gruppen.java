package database;


import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "Gruppen")
public class Gruppen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GruppenID")
    private int gruppenID;
    @Column(name = "Gruppenname")
    private String gruppenname;
    @Column(name = "Gruppenbild")
    private String gruppenbild;
    @Column(name = "ErstellungsDatum")
    private Date erstellungsDatum;

    public Gruppen(String gruppenname, String gruppenbild, Date erstellungsDatum) {
        this.gruppenname = gruppenname;
        this.gruppenbild = gruppenbild;
        this.erstellungsDatum = erstellungsDatum;
    }

    public int getGruppenID() {
        return gruppenID;
    }
    public void setGruppenID(int gruppenID) {
        this.gruppenID = gruppenID;
    }
    public String getGruppenname() {
        return gruppenname;
    }
    public void setGruppenname(String gruppenname) {
        this.gruppenname = gruppenname;
    }
    public String getGruppenbild() {
        return gruppenbild;
    }
    public void setGruppenbild(String gruppenbild) {
        this.gruppenbild = gruppenbild;
    }
    public Date getErstellungsDatum() {
        return erstellungsDatum;
    }
    public void setErstellungsDatum(Date erstellungsDatum) {
        this.erstellungsDatum = erstellungsDatum;
    }
}
