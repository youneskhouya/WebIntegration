import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

// Contrat RMI partagé : expose les méthodes que le client peut invoquer sur le serveur (IRemoteBank.RemoteBank)
public interface IRemoteBank extends Remote {

    // Lit le solde à distance via la position du compte dans la liste du serveur
    int getSolde(int index) throws RemoteException;

    // Lit le nom du propriétaire à distance via la position du compte
    String getName(int index) throws RemoteException;

    // Transmet un objet Compte du client vers le serveur (nécessite que Compte implémente Serializable)
    void addCompte(Compte compte) throws RemoteException;

    // Transmet un lot de comptes en une seule requête réseau (optimise les performances)
    void bulkCompte(List<Compte> comptes) throws RemoteException;

    // Classe serveur RMI : contient la logique métier et sera exposée aux clients
    class RemoteBank extends UnicastRemoteObject implements IRemoteBank {

        // Base de données locale en mémoire pour stocker les comptes
        private final List<Compte> cs;

        // Constructeur obligatoire pour RMI : exporte l'objet distant et initialise la liste
        public RemoteBank() throws RemoteException {
            super();
            cs = new ArrayList<>();
        }

        // Récupère le solde à distance via la position (index) du compte
        @Override
        public int getSolde(int index) throws RemoteException {
            return cs.get(index).getSolde();
        }

        // Récupère le nom du titulaire à distance via la position (index)
        @Override
        public String getName(int index) throws RemoteException {
            return cs.get(index).getName();
        }

        // Ajoute un compte (l'objet Compte transmis par le client doit être Serializable)
        @Override
        public void addCompte(Compte compte) throws RemoteException {
            cs.add(compte);
        }

        // Optimisation réseau : ajoute plusieurs comptes en un seul appel RMI
        @Override
        public void bulkCompte(List<Compte> comptes) throws RemoteException {
            cs.addAll(comptes);
        }
    }
}