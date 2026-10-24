package food_felivery_system;

public class ExpressDelivery implements DeliveryOption {
    @Override
    public double getFee() {
        return 5.0;
    }

    @Override
    public String getName() {
        return "Express";
    }
}

