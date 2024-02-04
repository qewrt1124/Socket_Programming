package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 2024.02.04
 * yang goo gang
 * Client implementation class
 */
public class Client {
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;

    public Client(String ip, int port) {
        try {
            // Send a request to a server
            socket = new Socket(ip, port);
            System.out.println(socket.getInetAddress().getHostAddress() + " | 통신 연결 성공");

            // get a message
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());

            // send a message
            pw.println("메시지 발송");
            pw.flush();

            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(socket != null) socket.close();
                if(br != null) br.close();
                if(pw != null) pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
