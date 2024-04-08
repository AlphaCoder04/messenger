package funktionalitaet;
import database.*;
public class Main {
    public static void main(String[] args) {
        GeneralDB db = new GeneralDB();
        db.createSF();
        db.createBenutzer("Max", "Mustermann", "max@example.com", "1234", "01.01.2000", "profilbild.jpg");
        db.closeSF();
    }
}
