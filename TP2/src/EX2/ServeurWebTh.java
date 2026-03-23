package EX2;

import java.net.*;
import java.io.*;

public class ServeurWebTh {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Serveur web démarré sur le port 8000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connecté : " + socket.getInetAddress());

                Thread t = new Thread(new ServiceWeb(socket));
                t.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
