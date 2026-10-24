package food_felivery_system;

public class StandardDelivery implements DeliveryOption {
    @Override
    public double getFee() {
        return 2.0;
    }

    @Override
    public String getName() {
        return "Standard";
    }
}
