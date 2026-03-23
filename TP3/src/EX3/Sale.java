package EX3;
import java.io.Serializable;

public class Sale implements Serializable {
    private int saleId;
    private String product;
    private String region;
    private double amount;
    private String date;

    public Sale(int saleId, String product, String region, double amount, String date) {
        this.saleId = saleId;
        this.product = product;
        this.region = region;
        this.amount = amount;
        this.date = date;
    }

    public int getSaleId() {
        return saleId;
    }

    public String getProduct() {
        return product;
    }

    public String getRegion() {
        return region;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", product='" + product + '\'' +
                ", region='" + region + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}
