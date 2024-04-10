import java.io.*;
import java.net.*;

public class Client2 {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your username:");
        String userName = stdIn.readLine();
        out.println(userName); // Benutzername an den Server senden

        new Thread(() -> {
            try {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
            } catch (IOException e) {
                System.out.println("Server connection lost.");
            }
        }).start();

        String userInput;
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput+":"+userName); // Format "zielbenutzername:nachricht"
        }
    }
}
