package Ex3;

public class Consommateur implements Runnable {
    private final File<Integer> file;
    private final int nbConsommations;

    public Consommateur(File<Integer> file, int nbConsommations) {
        this.file = file;
        this.nbConsommations = nbConsommations;
    }

    @Override
    public void run() {
        for (int i = 0; i < nbConsommations; i++) {
            try {
                Integer item = file.retirer();
                // Consommer = l'afficher (déjà affiché) ou traiter
                Thread.sleep(80); // juste pour visualiser
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
