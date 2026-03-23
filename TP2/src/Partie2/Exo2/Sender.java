package Partie2.Exo2;


import java.net.*;
import java.util.Random;

public class Sender {

    public static void main(String[] args) {

        int port = 7676;

        String[] proverbes = {
                "L'avenir appartient à ceux qui se lèvent tôt.",
                "Petit à petit, l'oiseau fait son nid.",
                "Après la pluie vient le beau temps.",
                "Qui ne tente rien n'a rien.",
                "Mieux vaut tard que jamais."
        };

        try {
            DatagramSocket socket = new DatagramSocket();

            Random random = new Random();
            String proverbe = proverbes[random.nextInt(proverbes.length)];

            byte[] message = proverbe.getBytes();

            InetAddress adresse = InetAddress.getByName("localhost");

            DatagramPacket packet = new DatagramPacket(
                    message,
                    message.length,
                    adresse,
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
