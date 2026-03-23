package Ex3;

import java.util.LinkedList;

public class File<T> {
    private final LinkedList<T> buffer = new LinkedList<>();
    private final int capacite;

    public File(int capacite) {
        this.capacite = capacite;
    }

    public synchronized void deposer(T item) throws InterruptedException {
        while (buffer.size() == capacite) {
            wait(); 
        }
        buffer.addLast(item); // FIFO
        System.out.println(Thread.currentThread().getName()
                + " dépose: " + item + " | taille=" + buffer.size());
        notifyAll(); 
    }

    public synchronized T retirer() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); 
        }
        T item = buffer.removeFirst(); 
        System.out.println(Thread.currentThread().getName()
                + " retire: " + item + " | taille=" + buffer.size());
        notifyAll(); 
        return item;
    }
}
