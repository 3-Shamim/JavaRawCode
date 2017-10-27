package Product;

/**
 *
 * @author MD SHAMIM
 */
public class Product {
    private final String productName;
    private final String Model;
    private final String Company;
    private final double Price;
    private final int Remainting;
    public Product(String productName,String Model, String Company, double Price, int Remaining)
    {
        this.productName = productName;
        this.Model = Model;
        this.Company = Company;
        this.Price = Price;
        this.Remainting = Remaining;
    }

    public String getProductName() {
        return productName;
    }

    public String getModel() {
        return Model;
    }

    public String getCompany() {
        return Company;
    }

    public double getPrice() {
        return Price;
    }

    public int getRemainting() {
        return Remainting;
    }
}
