package EX3;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class SalesServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            SalesService service = new SalesServiceImpl();

            // Ajout de quelques ventes d'exemple
            service.addSale(new Sale(1, "Laptop", "Nord", 12000, "2026-01-10"));
            service.addSale(new Sale(2, "Phone", "Sud", 8000, "2026-01-11"));
            service.addSale(new Sale(3, "Laptop", "Nord", 15000, "2026-01-12"));
            service.addSale(new Sale(4, "Tablet", "Est", 6000, "2026-01-13"));
            service.addSale(new Sale(5, "Phone", "Ouest", 9000, "2026-01-14"));

            Naming.rebind("rmi://localhost:1099/SalesService", service);

            System.out.println("Serveur RMI démarré. SalesService publié.");
        } catch (Exception e) {
            System.out.println("Erreur serveur : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
