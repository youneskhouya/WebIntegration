package Threed;

class ChiffresThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
    }
}
class LettresThread extends Thread {
    @Override
    public void run() {
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c + " ");
        }
    }
}
public class Ex1_Threads {
    public static void main(String[] args) {
        Thread t1 = new ChiffresThread();
        Thread t2 = new LettresThread();

        t1.start();
        t2.start();
    }
}

// sequenciel : oui (ordre fixe)
// concurent : non (l'ordre depend de l'ordonnanceur)
