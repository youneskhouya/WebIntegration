package EX1;

import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 9080);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            String proverbe = in.readLine();

            System.out.println("Proverbe reçu : " + proverbe);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
