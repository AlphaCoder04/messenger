package funktionalitaet;

import database.*;

public class Client {
    public static void main(String[] args) {

        GeneralDB db = new GeneralDB();

        LogIn logIn = new LogIn();
        logIn.start();

        db.closeSF();


    }
}
