import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.List;

// Point d'entrée du serveur : déploie et rend le service bancaire accessible
public class BankServeur {
    public static void main(String[] args) {
        try {
            // Démarre l'annuaire RMI (registre) sur le port standard 1099
            LocateRegistry.createRegistry(1099);

            // Instancie l'implémentation locale du service (créée dans le premier code)
            RemoteBank b = new RemoteBank();

            // Peuple la banque en mémoire avec des données initiales via l'interface
            b.bulkCompte(List.of(
                    new Compte(3000, "Ahmed"),
                    new Compte(4568, "med")
            ));

            // Associe l'objet distant à l'URL "mabank" dans l'annuaire pour que les clients le trouvent
            Naming.rebind("rmi://localhost:1099/mabank", b);

            System.out.println("Le serveur est maintenant en marche ....");
        } catch (Exception e) {
            e.printStackTrace(); // Affiche les erreurs liées au réseau ou au port déjà utilisé
        }
    }
}