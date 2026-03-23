package EX3;

import java.net.*;
import java.io.*;

public class ServiceChat implements Runnable {

    private Socket socket;
    private PrintWriter out;

    public ServiceChat(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);

            synchronized (ServeurChat.clients) {
                ServeurChat.clients.add(out);

                for (PrintWriter client : ServeurChat.clients) {
                    if (client != out) {
                        client.println(">>> Un nouveau client vient de se connecter.");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}