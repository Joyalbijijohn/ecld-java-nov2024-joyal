import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

    public class Main {
        public static void main(String[] args) {
            OrderItem item1 = new OrderItem("P001", 2, 80.0);
            OrderItem item2 = new OrderItem("P002", 1, 150.0);
            OrderItem item3 = new OrderItem("P003", 3, 50.0);
            OrderItem item4 = new OrderItem("P004", 1, 200.0);

            Order regularOrder1 = new RegularOrder("O001", "Ben", LocalDateTime.now(), Arrays.asList(item1, item2));
            Order regularOrder2 = new RegularOrder("O002", "Jim", LocalDateTime.now(), Arrays.asList(item3));
            Order priorityOrder1 = new PriorityOrder("O003", "Tom", LocalDateTime.now(), Arrays.asList(item4), true, 20.0);

            OrderProcessor orderProcessor = new OrderProcessor();

            orderProcessor.processOrder(regularOrder1);
            orderProcessor.processOrder(regularOrder2);
            orderProcessor.processOrder(priorityOrder1);

            System.out.println("Total Revenue: $" + orderProcessor.getTotalRevenue());
            System.out.println("Average Order Value: $" + orderProcessor.getAverageOrderValue());
            List<String> topCustomers = orderProcessor.getTopCustomers(2);
            System.out.println("Top Customers: " + topCustomers);
        }
    }

