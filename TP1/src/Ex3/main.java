package Ex3;

public class main {
    public static void main(String[] args) {

        File<Integer> file = new File<>(5); // capacité bornée

        int nbProduitsParProd = 20;
        int nbConsommationsParCons = 20;

        Thread p1 = new Thread(new Producteur(file, nbProduitsParProd), "Prod-1");
        Thread p2 = new Thread(new Producteur(file, nbProduitsParProd), "Prod-2");

        Thread c1 = new Thread(new Consommateur(file, nbConsommationsParCons), "Cons-1");
        Thread c2 = new Thread(new Consommateur(file, nbConsommationsParCons), "Cons-2");

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}
