import java.io.Serializable; // Import obligatoire pour le transfert réseau

// Objet métier transféré entre le client et le serveur.
// L'interface Serializable indique à Java que cet objet peut être transformé en octets (pour le réseau).
public class Compte implements Serializable {

    // Attributs encapsulés contenant les données du compte
    private int solde;
    private String Name;

    // Constructeur pour initialiser rapidement un compte (utilisé dans votre Serveur)
    public Compte(int solde, String Name) {
        this.solde = solde;
        this.Name = Name;
    }

    // Constructeur par défaut vide (bonne pratique, souvent requise par la sérialisation)
    public Compte() {
    }

    // --- Accesseurs (Getters / Setters) standards ---

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name; // Attention à la casse : conventionnellement, on écrit "this.name = name"
    }
}
