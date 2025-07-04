
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        CartItem item = new CartItem(product, quantity);
        items.add(item);
    }

    public List<CartItem> getItems() {
        return List.copyOf(items); 
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getSubtotal() {
        return items.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    public List<IShippable> getShippableItems() {
        return items.stream()
                .map(CartItem::getProduct)
                .filter(p -> p instanceof IShippable)
                .map(p -> (IShippable) p)
                .toList();
    }
}
