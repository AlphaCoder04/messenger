package database;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "Nachrichten")
public class Nachrichten {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NachrichtenID")
    private int nachrichtenID;
    @Column(name = "ChatID")
    private int chatID;
    @Column(name = "AbsenderID")
    private int absenderID;
    @Column(name = "Nachrichteninhalt")
    private String nachrichtenInhalt;
    @Column(name = "Sendezeit")
    private Timestamp sendeZeit;

    public Nachrichten(int chatID, int absenderID, String nachrichtenInhalt, Timestamp sendeZeit) {
        this.chatID = chatID;
        this.absenderID = absenderID;
        this.nachrichtenInhalt = nachrichtenInhalt;
        this.sendeZeit = sendeZeit;
    }

    public int getNachrichtenID() {
        return nachrichtenID;
    }
    public void setNachrichtenID(int nachrichtenID) {
        this.nachrichtenID = nachrichtenID;
    }
    public int getChatID() {
        return chatID;
    }
    public void setChatID(int chatID) {
        this.chatID = chatID;
    }
    public int getAbsenderID() {
        return absenderID;
    }
    public void setAbsenderID(int absenderID) {
        this.absenderID = absenderID;
    }
    public String getNachrichtenInhalt() {
        return nachrichtenInhalt;
    }
    public void setNachrichtenInhalt(String nachrichtenInhalt) {
        this.nachrichtenInhalt = nachrichtenInhalt;
    }
    public Timestamp getSendeZeit() {
        return sendeZeit;
    }
    public void setSendeZeit(Timestamp sendeZeit) {
        this.sendeZeit = sendeZeit;
    }
}
