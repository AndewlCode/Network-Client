
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class NetworkClient {
    private final String host;
    private final int port;

    public NetworkClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        try (Socket clienSocket = new Socket(this.host, this.port);
             PrintWriter out = new PrintWriter(clienSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()))) {
            out.println("George");
            String response = in.readLine();
            System.out.println(response);
        }
    }
}
