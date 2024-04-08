package database;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "Chats")
public class Chats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChatID")
    private int chatID;
    @Column(name = "Typ")
    private String typ;
    @Column(name = "Erstellungsdatum")
    private Timestamp erstellungsDatum;

    public Chats(String typ, Timestamp erstellungsDatum) {
        this.typ = typ;
        this.erstellungsDatum = erstellungsDatum;
    }

    public int getChatID() {
        return chatID;
    }
    public void setChatID(int chatID) {
        this.chatID = chatID;
    }
    public String getTyp() {
        return typ;
    }
    public void setTyp(String typ) {
        this.typ = typ;
    }
    public Timestamp getErstellungsDatum() {
        return erstellungsDatum;
    }
    public void setErstellungsDatum(Timestamp erstellungsDatum) {
        this.erstellungsDatum = erstellungsDatum;
    }
}
