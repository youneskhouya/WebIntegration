package Partie2.Exo3;

import java.net.*;
import java.util.Random;

public class MulticastSender {

    public static void main(String[] args) {

        String groupe = "224.0.0.1";
        int port = 8686;

        String[] proverbes = {
                "L'avenir appartient à ceux qui se lèvent tôt.",
                "Petit à petit, l'oiseau fait son nid.",
                "Après la pluie vient le beau temps.",
                "Qui ne tente rien n'a rien.",
                "Mieux vaut tard que jamais."
        };

        try {
            MulticastSocket socket = new MulticastSocket();

            InetAddress adresseGroupe = InetAddress.getByName(groupe);

            Random random = new Random();
            String proverbe = proverbes[random.nextInt(proverbes.length)];

            byte[] message = proverbe.getBytes();

            DatagramPacket packet = new DatagramPacket(
                    message,
                    message.length,
                    adresseGroupe,
                    port
            );

            socket.send(packet);

            System.out.println("Proverbe envoyé : " + proverbe);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}