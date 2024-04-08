package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class GeneralDB {
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

    public void createBenutzer(String vorname, String nachname, String email, String passwort, String geburtsdatum, String profilbild){
        Benutzer benutzer = new Benutzer(vorname, nachname, email, passwort, geburtsdatum, profilbild);

        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.save(benutzer);
        ses.getTransaction().commit();
        System.out.println("Benutzer:" + benutzer.getBenutzerID() + " erstellt");
        ses.close();
    }
}
