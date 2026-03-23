package EX3;

import java.rmi.Naming;
import java.util.List;
import java.util.Map;

public class SalesClient {
    public static void main(String[] args) {
        try {
            SalesService service = (SalesService) Naming.lookup(
                    "rmi://localhost:1099/SalesService"
            );

            System.out.println("=== Toutes les ventes ===");
            List<Sale> allSales = service.getAllSales();
            for (Sale sale : allSales) {
                System.out.println(sale);
            }

            System.out.println("\n=== Chiffre d'affaires total ===");
            System.out.println(service.getTotalRevenue());

            System.out.println("\n=== Chiffre d'affaires par région ===");
            Map<String, Double> revenueByRegion = service.getRevenueByRegion();
            for (Map.Entry<String, Double> entry : revenueByRegion.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            System.out.println("\n=== Produit le plus vendu ===");
            System.out.println(service.getBestSellingProduct());

            System.out.println("\n=== Ventes supérieures à 8000 ===");
            List<Sale> filteredSales = service.getSalesAboveAmount(8000);
            for (Sale sale : filteredSales) {
                System.out.println(sale);
            }

            // Exemple d'ajout d'une vente à distance
            service.addSale(new Sale(6, "Laptop", "Sud", 20000, "2026-01-15"));
            System.out.println("\nNouvelle vente ajoutée avec succès.");

            System.out.println("\n=== Nouveau chiffre d'affaires total ===");
            System.out.println(service.getTotalRevenue());

        } catch (Exception e) {
            System.out.println("Erreur client : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
