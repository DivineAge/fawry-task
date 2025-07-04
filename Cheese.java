
import java.time.LocalDate;

public class Cheese extends Product implements IExpirable, IShippable {
    private final LocalDate expiryDate;
    private final double weight;

    public Cheese(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, ProductType.FOOD);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
