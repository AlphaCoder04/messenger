package funktionalitaet;

import database.GeneralDB;

public class Main {
    public static void main(String[] args) {
        GeneralDB db = new GeneralDB();
        db.createChat("Gruppenchat");
        db.createChat("Privatchat");
        db.checkBenutzer("admin", "admin");
        //db.createBenutzer("vorname", "nachname", "benutzername", "email", "passwort", "21.10.2021", "profilbild");
        db.createNachricht(1, 1, "Hallo");
        db.createNachricht(1, 2, "Hi");
        db.showNachrichten(1);
        db.closeSF();
    }

}
