public class CartItem {
    private final Product product;
    private final int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be > 0");
        if (!product.isInStock(quantity)) throw new IllegalArgumentException("Not enough stock");

        if (product instanceof IExpirable expirable && expirable.isExpired()) {
            throw new IllegalStateException("Cannot add expired product to cart");
        }

        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
