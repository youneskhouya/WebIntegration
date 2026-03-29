package org.example;

import com.example.client.ICalculatrice;
import com.example.client.CalculatriceImpService;

public class Main {
    public static void main(String[] args) {
        CalculatriceImpService service = new CalculatriceImpService();
        ICalculatrice port = service.getCalculatriceImpServicePort();

        System.out.println("Somme = " + port.add(50, 40));
        System.out.println("Multiplication = " + port.multiply(5, 8));
        System.out.println("Soustraction = " + port.subtract(50, 40));
        System.out.println("Division = " + port.divide(20, 4));
    }
}
