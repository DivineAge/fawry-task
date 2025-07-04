public abstract class Product {
   private final String name;
   private final double price;
   private int quantity;
   private final ProductType type;

   public Product(String name, double price, int quantity, ProductType type) {
       if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
       if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
       if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");

       this.name = name;
       this.price = price;
       this.quantity = quantity;
       this.type = type;
   }

   public String getName() { return name; }
   public double getPrice() { return price; }
   public int getQuantity() { return quantity; }
   public ProductType getType() { return type; }

   public boolean isInStock(int requestedQty) {
       return requestedQty <= quantity;
   }

   public void decreaseStock(int qty) {
       if (qty > quantity) throw new IllegalStateException("Insufficient stock.");
       this.quantity -= qty;
   }
}
