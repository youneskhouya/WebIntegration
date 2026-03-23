package EX1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Receiver {
    public static void main(String[] args) {
        int port = 7676; // port par défaut

        // Point 4 : récupération du port depuis les arguments
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Port invalide. Utilisation du port par défaut : 7676");
            }
        }

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("EX1.Receiver en écoute sur le port " + port + "...");

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Message reçu de " +
                        packet.getAddress().getHostAddress() + ":" +
                        packet.getPort() + " -> " + message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}