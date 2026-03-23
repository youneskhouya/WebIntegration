package EX3;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface SalesService extends Remote {

    void addSale(Sale sale) throws RemoteException;

    double getTotalRevenue() throws RemoteException;

    Map<String, Double> getRevenueByRegion() throws RemoteException;

    String getBestSellingProduct() throws RemoteException;

    List<Sale> getSalesAboveAmount(double minAmount) throws RemoteException;

    List<Sale> getAllSales() throws RemoteException;
}
