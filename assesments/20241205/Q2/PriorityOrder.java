import java.time.LocalDateTime;
import java.util.List;

public class PriorityOrder extends Order {
    private boolean expressShipping;
    private double additionalFee;

    public PriorityOrder(String orderId, String customerName, LocalDateTime orderDate, List<OrderItem> items, boolean expressShipping, double additionalFee) {
        super(orderId, customerName, orderDate, items);
        this.expressShipping = expressShipping;
        this.additionalFee = additionalFee;
    }

    @Override
    public double calculateTotal() {
        double total = items.stream().mapToDouble(OrderItem.getTotalPrice()).sum();
        return total + (expressShipping ? additionalFee : 0);
    }

    @Override
    public double calculateDiscount() {
        return 0; // No discount for priority orders
    }
}