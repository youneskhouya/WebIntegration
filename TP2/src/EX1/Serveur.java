package EX1;

import java.net.*;
import java.io.*;
import java.util.Random;

public class Serveur {

    public static void main(String[] args) {

        String[] proverbes = {
                "L'avenir appartient à ceux qui se lèvent tôt.",
                "Petit à petit, l'oiseau fait son nid.",
                "Après la pluie vient le beau temps.",
                "Qui ne tente rien n'a rien.",
                "Mieux vaut tard que jamais."
        };

        try {
            ServerSocket serverSocket = new ServerSocket(9080);
            System.out.println("Serveur démarré sur le port 9080...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connecté : " + socket.getInetAddress());

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                Random random = new Random();
                String proverbe = proverbes[random.nextInt(proverbes.length)];

                out.println(proverbe);

                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}