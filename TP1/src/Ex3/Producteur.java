package Ex3;

import java.util.concurrent.atomic.AtomicInteger;

public class Producteur implements Runnable {
    private static final AtomicInteger compteur = new AtomicInteger(0);
    private final File<Integer> file;
    private final int nbProduits;

    public Producteur(File<Integer> file, int nbProduits) {
        this.file = file;
        this.nbProduits = nbProduits;
    }

    @Override
    public void run() {
        for (int i = 0; i < nbProduits; i++) {
            int produit = compteur.incrementAndGet();
            try {
                file.deposer(produit);
                Thread.sleep(50); // juste pour visualiser
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}