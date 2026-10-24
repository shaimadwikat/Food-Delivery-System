package food_felivery_system;

public class CashPayment implements PaymentMethod {
    @Override
    public double pay(double amount) {
        return amount;
    }

    @Override
    public String getName() {
        return "Cash";
    }
}
