package Exercice_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Compte {
    private int solde = 1000;
    private Lock lock = new ReentrantLock();

    public void retirer(int montant) {
        lock.lock();

        try {
            if (solde >= montant) {

                System.out.println(Thread.currentThread().getName()
                        + " va retirer " + montant);

                Thread.sleep(200);

                solde -= montant;

                System.out.println(Thread.currentThread().getName()
                        + " a retiré " + montant
                        + " | Solde restant: " + solde);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
