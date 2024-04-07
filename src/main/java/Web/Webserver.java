package Web;

import java.io.*;
import java.net.*;
public class Webserver {
    public static void main(String[] args) throws IOException {
        // Port, auf dem der Server lauschen soll
        int port = 8080;
        
        // Socket erstellen, um eingehende Verbindungen zu akzeptieren
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Web server listening on port " + port);
        
        while (true) {
            // Auf eingehende Verbindungen warten
            Socket clientSocket = serverSocket.accept();
            System.out.println("New connection from " + clientSocket.getInetAddress().getHostAddress());
            
            // Einlesen der Anfrage vom Client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String request = in.readLine();
            System.out.println("Request: " + request);
            
            // Antwort an den Client senden
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println();
            out.println("<html>");
            out.println("<head><title>Simple Web Server</title></head>");
            out.println("<body>");
            out.println("<h1>Hello, World!</h1>");
            out.println("</body>");
            out.println("</html>");
            
            // Aufräumen und Verbindung schließen
            out.close();
            in.close();
            clientSocket.close();
        }
    }
}
