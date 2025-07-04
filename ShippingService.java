
import java.util.List;

public class ShippingService {
    private static final int COST_PER_KG = 30;

    public static double calculateTotalWeight(List<CartItem> items) {
        return items.stream()
                .map(CartItem::getProduct)
                .filter(p -> p instanceof IShippable)
                .map(p -> (IShippable) p)
                .mapToDouble(sh -> {
                    CartItem item = items.stream()
                            .filter(ci -> ci.getProduct() == sh)
                            .findFirst()
                            .orElseThrow();
                    return sh.getWeight() * item.getQuantity();
                })
                .sum();
    }

    public static double calculateShippingCost(List<CartItem> items) {
        double totalWeight = items.stream()
                .map(CartItem::getProduct)
                .filter(p -> p instanceof IShippable)
                .map(p -> (IShippable) p)
                .mapToDouble(IShippable::getWeight)
                .sum();
        return Math.ceil(totalWeight) * COST_PER_KG;
    }
}
