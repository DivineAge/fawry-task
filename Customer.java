public class Customer {
    private final int id;
    private final String name;
    private final String address;
    private final String phone;
    private final Cart cart;
    private double balance;

    public Customer(int id, String name, String address, String phone, double balance) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.balance = balance;
        this.cart = new Cart(); // Each customer owns a cart
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhone() { return phone; }
    public double getBalance() { return balance; }
    public Cart getCart() { return cart; }

    public void pay(double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance.");
        }
        balance -= amount;
    }
}
