
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class NetworkClient {
    private final String host;
    private final int port;

    public NetworkClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {
        for (int i = 0; i < 10; i++) {
            try (Socket clienSocket = new Socket(this.host, this.port);
                 PrintWriter out = new PrintWriter(clienSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()))) {

                String command = getRandomCommand();
                out.println(command);
                String response = in.readLine();
                System.out.println(response);
            }
        }
    }

    // Генерация случайных команд для сервера
    public String getRandomCommand() {
        String[] commands = new String[]{
                "Hi",
                "Say Your name",
                "What date is it today",
                "What is yours favourite movie",
                "How old are you?",
                "Bye",
                "Where are you?",
                "UNKNOWN QUESTION"
        };
        Random random = new Random();
        return commands[random.nextInt(commands.length)];
    }
}
