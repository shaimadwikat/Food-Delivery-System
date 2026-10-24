package food_felivery_system;

public class Drink extends MenuItem {
    private boolean large;

    public Drink(String name, double basePrice, boolean large) {
        super(name, basePrice);
        this.large = large;
    }

    @Override
    public double calculateFinalPrice() {
        return getBasePrice() + (large ? 1 : 0);
    }
}
