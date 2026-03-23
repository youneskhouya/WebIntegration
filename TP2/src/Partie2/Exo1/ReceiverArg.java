package EX1;

import java.net.*;

public class ReceiverArg {
    public static void main(String[] args) {
        try {
            int port = Integer.parseInt(args[0]);
            DatagramSocket socket = new DatagramSocket(port);

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("EX1.Receiver en écoute sur le port " + port);
            socket.receive(packet);

            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Message reçu : " + message);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}