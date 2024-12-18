import java.time.LocalDateTime;
import java.util.List;

public class RegularOrder extends Order {
    private static final double MINIMUM_FOR_DISCOUNT = 100.0;
    private static final double DISCOUNT_PERCENT = 0.10;

    public RegularOrder(String orderId, String customerName, LocalDateTime orderDate, List<OrderItem> items) {
        super(orderId, customerName, orderDate, items);
    }

    @Override
    public double calculateTotal() {
        double total = items.stream().mapToDouble(OrderItem.getTotalPrice()).sum();
        return total - calculateDiscount();
    }

    @Override
    public double calculateDiscount() {
        double total = items.stream().mapToDouble(OrderItem.getTotalPrice()).sum();
        if (total >= MINIMUM_FOR_DISCOUNT) {
            return total * DISCOUNT_PERCENT;
        }
        return 0;
    }
}