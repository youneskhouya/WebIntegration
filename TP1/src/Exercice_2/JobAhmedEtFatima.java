package Exercice_2;

public class JobAhmedEtFatima implements Runnable {

    private Compte compte;

    public JobAhmedEtFatima(Compte compte) {
        this.compte = compte;
    }

    public void doRetrait(int montant) {
        compte.retirer(montant);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            doRetrait(10);
        }
    }
}
