import java.util.*;
import java.util.stream.Collectors;

    public class OrderProcessor {
        private List<Order> orders;

        public OrderProcessor() {
            this.orders = new LinkedList<>();
        }

        public void processOrder(Order order) {
            orders.add(order);
        }

        public List<Order> getOrdersByCustomer(String customerName) {
            return orders.stream()
                    .filter(order -> order.getCustomerName().equalsIgnoreCase(customerName))
                    .collect(Collectors.toList());
        }

        public double getTotalRevenue() {
            return orders.stream().mapToDouble(Order::calculateTotal).sum();
        }

        public double getAverageOrderValue() {
            return orders.isEmpty() ? 0 : getTotalRevenue() / orders.size();
        }

        public List<String> getTopCustomers(int n) {
            Map<String, Double> customerTotals = new HashMap<>();
            for (Order order : orders) {
                customerTotals.merge(order.getCustomerName(), order.calculateTotal(), Double::sum);
            }

            return customerTotals.entrySet().stream()
                    .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                    .limit(n)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }

        public Iterator<Order> iterator() {
            return orders.iterator();
        }
    }

