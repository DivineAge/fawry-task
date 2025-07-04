
import java.time.LocalDate;

public class FoodItem extends Product implements IExpirable {
    private final LocalDate expiryDate;

    public FoodItem(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity, ProductType.FOOD);
        this.expiryDate = expiryDate;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
