package Web;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.*;

public class Webserver {
    public static void main(String[] args) throws Exception {
        int port = 8080; // Portnummer, auf der der Server lauscht
        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(port), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // Standard-Executor verwenden
        server.start();
        System.out.println("Server läuft auf Port " + port);
    }

    static class MyHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            try {
                String requestMethod = exchange.getRequestMethod();
                if (requestMethod.equalsIgnoreCase("GET")) {
                    String response = readHtmlFile("/Users/alpha/Documents/GitHub/messenger/src/main/java/Web/login.html");
                    exchange.sendResponseHeaders(200, response.getBytes().length);
                    OutputStream os = exchange.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                exchange.sendResponseHeaders(500, 0); // Internal Server Error
                OutputStream os = exchange.getResponseBody();
                os.close();
            }
        }
    }

    static String readHtmlFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        }
        return contentBuilder.toString();
    }
}
