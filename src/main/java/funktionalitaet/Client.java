package funktionalitaet;

import database.*;

public class Client {

    private static boolean exit = false;
    public static void main(String[] args) {

        GeneralDB db = new GeneralDB();

        LogIn logIn = new LogIn();
        logIn.start();

        db.closeSF();


    }

    public static void exit() {
        exit = true;
    }
}
