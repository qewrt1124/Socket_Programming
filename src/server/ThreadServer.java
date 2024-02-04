package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 2024.02.04
 * yang goo gang
 * Thread Server Implementation Class
 */
public class ThreadServer implements Runnable {
    private Socket socket;

    public ThreadServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ServerImplentation();
    }

    public void ServerImplentation() {
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            String connIp = socket.getInetAddress().getHostAddress();
            System.out.println(connIp + " | 통신 시도");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream());

            // Output of a string sent by the client
            System.out.println(br.readLine());

            // Output string to client
            pw.println("수신 완료");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null) br.close();
                if(pw != null) pw.close();
                if(socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
