package food_felivery_system;

import java.util.ArrayList;

public class Order {
    private static int nextOrderNumber = 1001;

    private int orderNumber;
    private String customerName;
    private DeliveryOption deliveryOption;
    private OrderStatus status;
    private ArrayList<OrderLine> orderLines;

    public Order(String customerName, DeliveryOption deliveryOption) {
        this.orderNumber = nextOrderNumber++;
        this.customerName = customerName;
        this.deliveryOption = deliveryOption;
        this.status = OrderStatus.NEW;
        this.orderLines = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        addItem(item, 1);
    }

    public void addItem(MenuItem item, int quantity) {
        if (status != OrderStatus.NEW) {
            throw new IllegalStateException(
                "Only NEW orders can have items added."
            );
        }

        orderLines.add(new OrderLine(item, quantity));
    }

    public double calculateSubtotal() {
        double subtotal = 0;

        for (OrderLine line : orderLines) {
            subtotal += line.getLineTotal();
        }

        return subtotal;
    }

    public double calculateTotal() {
        return calculateSubtotal() + deliveryOption.getFee();
    }

    public double makePayment(PaymentMethod paymentMethod) {
        if (status != OrderStatus.NEW) {
            throw new IllegalStateException(
                "Order must be NEW before payment."
            );
        }

        double amount = paymentMethod.pay(calculateTotal());
        status = OrderStatus.PAID;

        return amount;
    }

    public void deliver() {
        if (status != OrderStatus.PAID) {
            throw new IllegalStateException(
                "Only PAID orders can be delivered."
            );
        }

        status = OrderStatus.DELIVERED;
    }

    public void cancel() {
        if (status != OrderStatus.NEW) {
            throw new IllegalStateException(
                "Only NEW orders can be cancelled."
            );
        }

        status = OrderStatus.CANCELLED;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }
}
