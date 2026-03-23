package EX1;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServeurFibonacci {
    public static void main(String[] args) {
        try {
            // Lancer le registre RMI sur le port 1099
            LocateRegistry.createRegistry(1099);

            // Créer l'objet distant
            FibonacciService service = new FibonacciServiceImpl();

            // Publier l'objet
            Naming.rebind("rmi://localhost:1099/FibonacciService", service);

            System.out.println("Serveur RMI démarré. Service Fibonacci publié.");
        } catch (Exception e) {
            System.out.println("Erreur serveur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
