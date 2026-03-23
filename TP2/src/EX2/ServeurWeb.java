package EX2;

import java.net.*;
import java.io.*;

public class ServeurWeb {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Serveur web démarré sur le port 8000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connecté : " + socket.getInetAddress());

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String corps = "<HTML><TITLE>Mon serveur</TITLE>"
                        + "Cette page a été envoyée par mon <B>Serveur</B>"
                        + "</HTML>";

                out.println("HTTP/1.0 200 OK");
                out.println();
                out.println(corps);

                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
