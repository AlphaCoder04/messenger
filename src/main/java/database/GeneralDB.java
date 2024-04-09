package database;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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

    public void checkBenutzer(String benutzername, String passwort){
        Session ses = sf.openSession();
        ses.beginTransaction();

        SQLQuery query = ses.createSQLQuery("SELECT * FROM Benutzer WHERE Benutzername = :benutzername AND Passwort = :passwort");
        query.setParameter("benutzername", benutzername).setParameter("passwort", passwort);
        List result = query.list();
        if(result.size() == 1){
            System.out.println("Erfolgreich eingeloggt");
        } else {
            System.out.println("Falsche Eingabe");
        }
        ses.getTransaction().commit();
        ses.close();
    }
}
