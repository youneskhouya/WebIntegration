package EX1;

import java.net.*;
import java.util.Scanner;
import java.util.Random;

public class SenderProverbe {
    public static void main(String[] args) {
        try {
            String[] proverbes = {
                    "Qui vivra verra",
                    "Après la pluie le beau temps",
                    "Petit à petit l'oiseau fait son nid",
                    "Mieux vaut tard que jamais",
                    "L'habit ne fait pas le moine"
            };

            Scanner sc = new Scanner(System.in);
            System.out.print("Donner le port : ");
            int port = sc.nextInt();

            Random random = new Random();
            String message = proverbes[random.nextInt(proverbes.length)];

            InetAddress address = InetAddress.getByName("localhost");
            DatagramSocket socket = new DatagramSocket();

            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);

            socket.send(packet);

            System.out.println("Proverbe envoyé : " + message);

            socket.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
