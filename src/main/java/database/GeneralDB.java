package database;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Timestamp;
import java.util.List;

public class GeneralDB {

    public GeneralDB() {
        createSF();
    }
    protected SessionFactory sf;
    public void createSF(){
        final StandardServiceRegistry register = new StandardServiceRegistryBuilder().configure().build();
        try {
            sf = new MetadataSources(register).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SessionFactory getSf() {
        return sf;
    }

    public void closeSF(){
        sf.close();
    }

    public void createBenutzer(String vorname, String nachname,String benutzername, String email, String passwort, String geburtsdatum, String profilbild){
        Benutzer benutzer = new Benutzer(vorname, nachname, benutzername, email, passwort, geburtsdatum, profilbild);
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.save(benutzer);
        ses.getTransaction().commit();
        System.out.println("Benutzer:" + benutzer.getBenutzerID() + " erstellt");
        ses.close();
    }

    public boolean checkBenutzer(String benutzername, String passwort){
        boolean success = false;
        Session ses = sf.openSession();
        ses.beginTransaction();

        SQLQuery query = ses.createSQLQuery("SELECT * FROM Benutzer WHERE Benutzername = :benutzername AND Passwort = :passwort");
        query.setParameter("benutzername", benutzername).setParameter("passwort", passwort);
        List result = query.list();
        if(result.size() == 1){
            System.out.println("Erfolgreich eingeloggt");
            success = true;
        } else {
            System.out.println("Falsche Eingabe");
            success = false;
        }
        ses.getTransaction().commit();
        ses.close();
        return success;
    }

    public void createChat(String typ){
        Timestamp t = new Timestamp(System.currentTimeMillis());
        Chats chat = new Chats(typ, t);
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.save(chat);
        ses.getTransaction().commit();
        System.out.println("Chat:" + chat.getChatID() + " erstellt");
        ses.close();
    }
    public void createNachricht(int chatID, int absenderID, String nachrichtenInhalt ){
        Timestamp t = new Timestamp(System.currentTimeMillis());
        Nachrichten nachricht = new Nachrichten(chatID, absenderID ,nachrichtenInhalt, t);
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.save(nachricht);
        ses.getTransaction().commit();
        //System.out.println("Nachricht:" + nachricht.getNachrichtenID() + " erstellt");
        ses.close();
    }

    public void showNachrichten(int chatID){
        Session ses = sf.openSession();
        ses.beginTransaction();
        SQLQuery query = ses.createSQLQuery("SELECT * FROM Nachrichten WHERE ChatID = :chatID");
        query.setParameter("chatID", chatID);
        List result = query.list();
        for (Object o : result) {
            System.out.println(o);
        }
        ses.getTransaction().commit();
        ses.close();
    }
    public void showChats(){
        Session ses = sf.openSession();
        ses.beginTransaction();
        SQLQuery query = ses.createSQLQuery("SELECT * FROM Chats");
        List result = query.list();
        for (Object o : result) {
            System.out.println(o);
        }
        ses.getTransaction().commit();
        ses.close();
    }
}
