import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        
        Customer customer = new Customer(1, "Yussuf", "Cairo", "0100-1234567", 1000);

       
        Product cheese = new Cheese("Cheese", 100, 10, LocalDate.now().plusDays(2), 0.2); 
        Product biscuits = new Cheese("Biscuits", 150, 5, LocalDate.now().plusDays(3), 0.7); 

        
        customer.getCart().addItem(cheese, 2);  
        customer.getCart().addItem(biscuits, 1); 

        
        CheckoutService.checkout(customer);
    }
}
