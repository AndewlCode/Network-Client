public class Main {
    public static void main(String[] args) throws Exception {
        String serverHostname = "127.0.0.1";
        int serverPort = 8089;
        NetworkClient networkClient = new NetworkClient(serverHostname, serverPort);
        networkClient.start();
    }
}
