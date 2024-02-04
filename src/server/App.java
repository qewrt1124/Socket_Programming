package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2024.02.04
 * yang goo gang
 * Server Application class
 */
public class App {
    private static final int PORT = 4432;

    public static void main(String[] args) {
        System.out.println("::: Socket Application Start :::");

        try(ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket connetion = server.accept();
                ThreadServer task = new ThreadServer(connetion);
                task.run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
