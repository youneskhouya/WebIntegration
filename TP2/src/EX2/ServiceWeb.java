package EX2;

import java.net.*;
import java.io.*;

public class ServiceWeb implements Runnable {

    private Socket socket;

    public ServiceWeb(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader fichier = new BufferedReader(
                    new FileReader("src/EX2/page.html")
            );

            String ligne;
            StringBuilder corps = new StringBuilder();

            while ((ligne = fichier.readLine()) != null) {
                corps.append(ligne);
            }

            fichier.close();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("HTTP/1.0 200 OK");
            out.println("Content-Type: text/html; charset=UTF-8");
            out.println();
            out.println(corps.toString());

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
