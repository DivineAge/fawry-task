

public class CheckoutService {
    public static void checkout(Customer customer ) {
        Cart cart = customer.getCart();

        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();

            if (!product.isInStock(item.getQuantity())) {
                throw new IllegalStateException(product.getName() + " is out of stock.");
            }

            if (product instanceof IExpirable expirable && expirable.isExpired()) {
                throw new IllegalStateException(product.getName() + " is expired.");
            }
        }

        
        System.out.println("** Shipment notice **");
        double totalWeight = 0.0;

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            if (p instanceof IShippable shippable) {
                double itemWeight = shippable.getWeight() * item.getQuantity();
                totalWeight += itemWeight;
                System.out.printf("%dx %s %.0fg%n", item.getQuantity(), p.getName(), itemWeight * 1000);
            }
        }

        System.out.printf("Total package weight %.1fkg%n", totalWeight);

        
        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s %.0f%n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }

        System.out.println("----------------------");

        double subtotal = cart.getSubtotal();
        double shipping = Math.ceil(totalWeight) * 30;
        double total = subtotal + shipping;

        System.out.printf("Subtotal %.0f%n", subtotal);
        System.out.printf("Shipping %.0f%n", shipping);
        System.out.printf("Amount %.0f%n", total);

        customer.pay(total);
    }
}
