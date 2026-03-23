package EX2;

import java.net.*;
import java.io.*;

public class ServWeb {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Serveur web démarré sur le port 8000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connecté : " + socket.getInetAddress());

                BufferedReader fichier = new BufferedReader(
                        new FileReader("src/EX2/page.html")
                );

                String ligne;
                String corps = "";

                while ((ligne = fichier.readLine()) != null) {
                    corps += ligne;
                }

                fichier.close();

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

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