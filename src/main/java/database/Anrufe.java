package database;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Anrufe")
public class Anrufe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AnrufID")
    private int anrufID;
    @Column(name = "AnruferID")
    private int anruferId;
    @Column(name = "EmpfaengerID")
    private int empfaengerId;
    @Column(name = "Anrufzeit")
    private Timestamp anrufZeit;
    @Column(name = "Dauer")
    private int dauer;
    @Column(name = "Anrufart")
    private String anrufArt;

    public Anrufe(int empfaengerId, Timestamp anrufZeit, int dauer, String anrufArt) {
        this.empfaengerId = empfaengerId;
        this.anrufZeit = anrufZeit;
        this.dauer = dauer;
        this.anrufArt = anrufArt;
    }

    public int getAnrufID() {
        return anrufID;
    }
    public void setAnrufID(int anrufID) {
        this.anrufID = anrufID;
    }
    public int getAnruferId() {
        return anruferId;
    }
    public void setAnruferId(int anruferId) {
        this.anruferId = anruferId;
    }
    public int getEmpfaengerId() {
        return empfaengerId;
    }
    public void setEmpfaengerId(int empfaengerId) {
        this.empfaengerId = empfaengerId;
    }
    public Timestamp getAnrufZeit() {
        return anrufZeit;
    }
    public void setAnrufZeit(Timestamp anrufZeit) {
        this.anrufZeit = anrufZeit;
    }
    public int getDauer() {
        return dauer;
    }
    public void setDauer(int dauer) {
        this.dauer = dauer;
    }
    public String getAnrufArt() {
        return anrufArt;
    }
    public void setAnrufArt(String anrufArt) {
        this.anrufArt = anrufArt;
    }

}
