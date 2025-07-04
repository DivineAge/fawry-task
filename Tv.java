public class Tv extends Product implements IShippable {
    private final double weight;

    public Tv(String name, double price, int quantity, double weight) {
        super(name, price, quantity, ProductType.ELECTRONICS);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
