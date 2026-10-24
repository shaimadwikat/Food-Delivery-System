package food_felivery_system;

public class Main {
    public static void main(String[] args) {
        MenuItem burger =
            new Meal("Burger Meal", 8.0, 1);

        MenuItem juice =
            new Drink("Juice", 3.0, true);

        Order order =
            new Order("Shaima", new ExpressDelivery());

        order.addItem(burger, 2);
        order.addItem(juice);

        System.out.println(
            "Subtotal: $" + order.calculateSubtotal()
        );

        System.out.println(
            "Total: $" + order.calculateTotal()
        );

        double paid =
            order.makePayment(new CardPayment());

        System.out.printf("Paid by card: $%.2f%n", paid);

        order.deliver();
        
        System.out.println("Status: " + order.getStatus());
    }
}