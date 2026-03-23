package EX1;

import java.rmi.Naming;
import java.util.Scanner;

public class ClientFibonacci {
    public static void main(String[] args) {
        try {
            FibonacciService service = (FibonacciService) Naming.lookup(
                    "rmi://localhost:1099/FibonacciService"
            );

            Scanner scanner = new Scanner(System.in);
            System.out.print("Entrer un entier n : ");
            int n = scanner.nextInt();

            long resultat = service.calculerFibonacci(n);
            System.out.println("Fibonacci(" + n + ") = " + resultat);

            scanner.close();
        } catch (Exception e) {
            System.out.println("Erreur client : " + e.getMessage());
            e.printStackTrace();
        }
    }
}