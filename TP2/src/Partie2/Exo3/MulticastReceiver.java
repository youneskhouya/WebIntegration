package Partie2.Exo3;

import java.net.*;

public class MulticastReceiver {

    public static void main(String[] args) {

        String groupe = "224.0.0.1";
        int port = 8686;

        try {
            MulticastSocket socket = new MulticastSocket(port);
            InetAddress adresseGroupe = InetAddress.getByName(groupe);

            socket.joinGroup(adresseGroupe);

            System.out.println("MulticastReceiver en écoute sur " + groupe + ":" + port);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Message reçu : " + message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
