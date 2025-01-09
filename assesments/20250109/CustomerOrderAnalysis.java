import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

    public class CustomerOrderAnalysis {

        public Map<String, Double> analyzeOrders(List<Order> orders) {
            return orders.stream()
                    .filter(order -> order.getAmount() > 100 && order.getOrderDate().getYear() == 2024)
                    .collect(Collectors.groupingBy(Order::getCustomerId, Collectors.summingDouble(Order::getAmount)));
        }

        public static void main(String[] args) {
            CustomerOrderAnalysis analyzer = new CustomerOrderAnalysis();
            List<Order> orders = Arrays.asList(
                    new Order("C1", 150.0, Arrays.asList("Item1", "Item2"), LocalDate.of(2024, 1, 15)),
                    new Order("C1", 50.0, Arrays.asList("Item3"), LocalDate.of(2024, 1, 20)),
                    new Order("C2", 200.0, Arrays.asList("Item1", "Item4"), LocalDate.of(2024, 1, 15)),
                    new Order("C1", 120.0, Arrays.asList("Item2", "Item5"), LocalDate.of(2023, 12, 15))
            );

            Map<String, Double> result = analyzer.analyzeOrders(orders);
            result.forEach((customerId, totalAmount) -> System.out.println("Customer ID: " + customerId + ", Total Amount: " + totalAmount));
        }
    }

    class Order {
        private String customerId;
        private double amount;
        private List<String> items;
        private LocalDate orderDate;

        public Order(String customerId, double amount, List<String> items, LocalDate orderDate) {
            this.customerId = customerId;
            this.amount = amount;
            this.items = items;
            this.orderDate = orderDate;
        }

        public String getCustomerId() {
            return customerId;
        }

        public double getAmount() {
            return amount;
        }

        public List<String> getItems() {
            return items;
        }

        public LocalDate getOrderDate() {
            return orderDate;
        }
    }

