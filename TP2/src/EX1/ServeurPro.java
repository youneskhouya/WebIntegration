package EX1;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class ServeurPro {

    public static void main(String[] args) {

        ArrayList<String> proverbes = new ArrayList<>();

        try {
            BufferedReader fichier = new BufferedReader(new FileReader("src/EX1/proverbes.txt"));
            String ligne;

            while ((ligne = fichier.readLine()) != null) {
                if (!ligne.trim().isEmpty()) {
                    proverbes.add(ligne);
                }
            }

            fichier.close();

            if (proverbes.isEmpty()) {
                System.out.println("Le fichier des proverbes est vide.");
                return;
            }

            ServerSocket serverSocket = new ServerSocket(9080);
            System.out.println("Serveur démarré sur le port 9080...");

            Random random = new Random();

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connecté : " + socket.getInetAddress());

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String proverbe = proverbes.get(random.nextInt(proverbes.size()));
                out.println(proverbe);

                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}