package EX1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FibonacciServiceImpl extends UnicastRemoteObject implements FibonacciService {

    protected FibonacciServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public long calculerFibonacci(int n) throws RemoteException {
        if (n < 0) {
            throw new RemoteException("n doit être positif");
        }
        long a=0;
        long b=1;
        long c;
        for (int i = 1; i <= n; i++) {
            c = a + b;
            b = a;
            a = c;

        }
        return a;

    }
}