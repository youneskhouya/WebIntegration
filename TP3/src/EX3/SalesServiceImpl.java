package EX3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesServiceImpl extends UnicastRemoteObject implements SalesService {

    private List<Sale> sales;

    protected SalesServiceImpl() throws RemoteException {
        super();
        sales = new ArrayList<>();
    }

    @Override
    public void addSale(Sale sale) throws RemoteException {
        sales.add(sale);
    }

    @Override
    public double getTotalRevenue() throws RemoteException {
        double total = 0;
        for (Sale sale : sales) {
            total += sale.getAmount();
        }
        return total;
    }

    @Override
    public Map<String, Double> getRevenueByRegion() throws RemoteException {
        Map<String, Double> revenueByRegion = new HashMap<>();

        for (Sale sale : sales) {
            String region = sale.getRegion();
            double amount = sale.getAmount();

            revenueByRegion.put(region,
                    revenueByRegion.getOrDefault(region, 0.0) + amount);
        }

        return revenueByRegion;
    }

    @Override
    public String getBestSellingProduct() throws RemoteException {
        Map<String, Integer> productCount = new HashMap<>();

        for (Sale sale : sales) {
            String product = sale.getProduct();
            productCount.put(product, productCount.getOrDefault(product, 0) + 1);
        }

        String bestProduct = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : productCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                bestProduct = entry.getKey();
            }
        }

        return bestProduct;
    }

    @Override
    public List<Sale> getSalesAboveAmount(double minAmount) throws RemoteException {
        List<Sale> result = new ArrayList<>();

        for (Sale sale : sales) {
            if (sale.getAmount() > minAmount) {
                result.add(sale);
            }
        }

        return result;
    }

    @Override
    public List<Sale> getAllSales() throws RemoteException {
        return sales;
    }
}
