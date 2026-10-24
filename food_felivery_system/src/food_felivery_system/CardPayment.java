package food_felivery_system;

public class CardPayment implements PaymentMethod {
    @Override
    public double pay(double amount) {
        return amount * 1.02;
    }

    @Override
    public String getName() {
        return "Card";
    }
}