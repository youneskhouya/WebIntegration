package Exercice_2;

public class Main {
    public static void main(String[] args) {

        Compte compteCommun = new Compte();

        JobAhmedEtFatima job = new JobAhmedEtFatima(compteCommun);

        Thread ahmed = new Thread(job);
        Thread fatima = new Thread(job);

        ahmed.setName("Ahmed");
        fatima.setName("Fatima");

        ahmed.start();
        fatima.start();
    }
}
