package EX1;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FibonacciService extends Remote {
    long calculerFibonacci(int n) throws RemoteException;
}
