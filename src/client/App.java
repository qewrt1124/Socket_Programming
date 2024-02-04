package client;

/**
 * 2024.02.04
 * yang goo gang
 * Client Application class
 */
public class App {
    public static void main(String[] args) {
        String ip = "183.109.201.110";
        int port = 4432;
        new Client(ip, port);
    }
}
