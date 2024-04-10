import database.GeneralDB;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class ChatServer {
    private static final int PORT = 12345;
    private static Map<String, PrintWriter> clientMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Server starting...");
        ServerSocket serverSocket = new ServerSocket(PORT);

        try {
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String name;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            //GeneralDB db = new GeneralDB();
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Erster Input ist der Benutzername
                name = in.readLine().trim();



                synchronized (clientMap) {
                    clientMap.put(name, out);
                }

                String input;
                while ((input = in.readLine()) != null) {
                    // Annahme: Format "zielbenutzername:nachricht"


                    int sepIndex = input.indexOf(':');
                    if (sepIndex > 0) {
                        String destUserName = input.substring(0, sepIndex);
                        String message = input.substring(sepIndex + 1);
                        String fromUser = message.split(":")[1];
                        message = message.split(":")[0];
                        //


                        PrintWriter destOut = clientMap.get(destUserName);
                        if (destOut != null) {
                            System.out.println("FROM: "+fromUser+" TO: "+destUserName+" MESSAGE: "+message);
                            destOut.println(name + ": " + message);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                if (name != null) {
                    clientMap.remove(name);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Couldn't close a socket");
                }
            }
        }
    }
}
