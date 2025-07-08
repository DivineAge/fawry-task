import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        // Customer setup
        Customer customer = new Customer(1, "Yussuf", "Cairo", "0100-1234567", 1000);

        // Products
        Product cheese = new Cheese("Cheese", 100, 10, LocalDate.now().plusDays(2), 0.2); // 200g each
        Product biscuits = new Cheese("Biscuits", 150, 5, LocalDate.now().plusDays(3), 0.7); // 700g each

        // Add to cart
        customer.getCart().addItem(cheese, 2);   // 2x Cheese = 200
        customer.getCart().addItem(biscuits, 1); // 1x Biscuits = 150

        /
        CheckoutService.checkout(customer);
    }
}
