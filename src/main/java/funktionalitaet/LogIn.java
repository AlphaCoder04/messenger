package funktionalitaet;

import database.Benutzer;
import database.GeneralDB;

import java.util.Scanner;

public class LogIn {
    private static boolean exit = false;
    private static GeneralDB db = new GeneralDB();
    public static void start() {
        System.out.println("Willkommen im Messenger");
        System.out.println("Möchten Sie sich einloggen oder registrieren?");
        System.out.println("Tippen Sie 1 für Einloggen, 2 für Registrieren und 3 für Beenden");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                einloggen();
                break;
            case 2:
                registrieren();
                break;
            case 3:
                System.out.println("Auf Wiedersehen!");
                break;
            default:
                System.out.println("Falsche Eingabe");
                break;
        }
    }
    public static void einloggen() {
        System.out.println("Bitte geben Sie Ihren Benutzernamen ein");
        Scanner scanner = new Scanner(System.in);
        String benutzername = scanner.nextLine();
        System.out.println("Bitte geben Sie Ihr Passwort ein");
        String passwort = scanner.nextLine();
        if(db.checkBenutzer(benutzername, passwort)){
            System.out.println("Willkommen " + benutzername + "!");
        } else {
            System.out.println("Versuchen Sie es erneut!");
            start();
        }
    }
    public static void registrieren() {
        System.out.println("Bitte geben Sie Ihren Vornamen ein");
        Scanner scanner = new Scanner(System.in);
        String vorname = scanner.nextLine();
        System.out.println("Bitte geben Sie Ihren Nachnamen ein");
        String nachname = scanner.nextLine();
        System.out.println("Bitte geben Sie Ihren Benutzernamen ein");
        String benutzername = scanner.nextLine();
        System.out.println("Bitte geben Sie Ihre Email ein");
        String email = scanner.nextLine();
        System.out.println("Bitte geben Sie Ihr Passwort ein");
        String passwort = scanner.nextLine();
        System.out.println("Bitte geben Sie Ihr Geburtsdatum ein");
        String geburtsdatum = scanner.nextLine();
        System.out.println("Bitte geben Sie Ihr Profilbild ein");
        String profilbild = scanner.nextLine();

        try {
            db.createBenutzer(vorname, nachname, benutzername, email, passwort, geburtsdatum, profilbild);
        } catch (Exception e) {
            System.out.println("Fehler beim Erstellen des Benutzers! Probieren Sie es erneut.");
            start();
        }

    }
}
