package EX1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Sender {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 7676;
        String message = "bonjour tout le monde";

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(host);

            byte[] buffer = message.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
            socket.send(packet);

            System.out.println("Message envoyé à " + host + ":" + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}