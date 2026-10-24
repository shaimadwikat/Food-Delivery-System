package food_felivery_system;

public interface PaymentMethod {
    double pay(double amount);
    String getName();
}
