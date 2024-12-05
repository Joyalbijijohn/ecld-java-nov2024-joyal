import java.time.LocalDateTime;
import java.util.List;

    public abstract class Order {
        protected String orderId;
        protected String customerName;
        protected LocalDateTime orderDate;
        protected List<Order> items;

        public Order(String orderId, String customerName, LocalDateTime orderDate, List<Order> items) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.orderDate = orderDate;
            this.items = items;
        }

        public abstract double calculateTotal();
        public abstract double calculateDiscount();

        public String getCustomerName() {
            return customerName;
        }

        public List<Order> getItems() {
            return items;
        }
    }

