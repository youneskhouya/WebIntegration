package EX3;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class ServeurChat {

    public static ArrayList<PrintWriter> clients = new ArrayList<>();

    public static void main(String[] args) {

        int port = 9090;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Serveur de chat démarré sur le port " + port + "...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Nouveau client connecté : " + socket.getInetAddress());

                Thread t = new Thread(new ServiceChat(socket));
                t.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}