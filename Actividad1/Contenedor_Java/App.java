import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(5000), 0);
        server.createContext("/", new TimeHandler());
        server.setExecutor(null); // usa el executor predeterminado
        System.out.println("Server is running on port 5000");
        server.start();
    }

    static class TimeHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Current time is: " + LocalDateTime.now();
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}