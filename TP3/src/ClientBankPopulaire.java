import java.rmi.Naming;

// Client RMI : se connecte au serveur pour consommer les services de la banque
public class ClientBankPopulaire {
    public static void main(String[] args) throws Exception {

        // Interroge l'annuaire RMI local (127.0.0.1:1099) pour trouver le service "mabank"
        // Récupère le "stub" (représentant local) et le caste via le contrat commun IRemoteBank
        IRemoteBank bp = (IRemoteBank) Naming.lookup("rmi://127.0.0.1:1099/mabank");

        // Fait un appel réseau transparent vers le serveur pour lire le 1er compte (index 0)
        System.out.println("Le nom de Propriataire 0 est : " + bp.getName(0));

        // Fait un appel réseau transparent pour lire le solde du 2ème compte (index 1)
        System.out.println("Le solde de Propriataire 1 est : " + bp.getSolde(1));
    }
}
