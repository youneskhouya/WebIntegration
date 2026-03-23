
package Partie2.Exo2;
import java.net.*;


public class Receiver {

    public static void main(String[] args) {

        int port = 7676;

        try {
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Receiver en attente sur le port " + port + "...");

            byte[] buffer = new byte[1024];

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);

            String message = new String(packet.getData(), 0, packet.getLength());

            System.out.println("Message reçu : " + message);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
