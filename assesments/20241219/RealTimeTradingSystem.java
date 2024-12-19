import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

    public class RealTimeTradingSystem {

        // TransactionType Enum
        public enum TransactionType {
            BUY,SELL}

        // Transaction Class
        public static class Transaction {
            private Long transactionId;
            private String symbol;
            private double amount;
            private TransactionType type;
            private LocalDateTime timestamp;

            public Transaction(Long transactionId, String symbol, double amount, TransactionType type) {
                this.transactionId = transactionId;
                this.symbol = symbol;
                this.amount = amount;
                this.type = type;
                this.timestamp = LocalDateTime.now();
            }

            // Setting Getters
            public Long getTransactionId() {
                return transactionId;
            }

            public String getSymbol() {
                return symbol;
            }

            public double getAmount() {
                return amount;
            }

            public TransactionType getType() {
                return type;
            }

            public LocalDateTime getTimestamp() {
                return timestamp;
            }
        }

        // TradingSystem Interface
        public interface TradingSystem {
            void processTransaction(Transaction transaction);

            void rollbackTransaction(Long transactionId);

            Iterator<Transaction> getTransactionsByTimeWindow(Duration window);

            double getAggregateAmount(String symbol, Duration window);
        }

        // TradingProcessor Class implementing and the TradingSystem
        public static class TradingProcessor implements TradingSystem {
            private List<Transaction> activeTransactions;
            private List<Transaction> historicalData;

            public TradingProcessor() {
                this.activeTransactions = new ArrayList<>();
                this.historicalData = new ArrayList<>();
            }

            @Override
            public void processTransaction(Transaction transaction) {
                // Mistake: Adding transaction to historicalData only, not to activeTransactions
                historicalData.add(transaction);
            }

            @Override
            public void rollbackTransaction(Long transactionId) {
                // Mistake: Not checking if the transaction exists before removing
                activeTransactions.removeIf(transaction -> transaction.getTransactionId().equals(transactionId));
            }

            @Override
            public Iterator<Transaction> getTransactionsByTimeWindow(Duration window) {
                LocalDateTime now = LocalDateTime.now();
                // Mistake: Using historicalData instead of activeTransactions
                List<Transaction> filteredTransactions = historicalData.stream()
                        .filter(transaction -> Duration.between(transaction.getTimestamp(), now).compareTo(window) <= 0)
                        .collect(Collectors.toList());
                return filteredTransactions.iterator();
            }

            @Override
            public double getAggregateAmount(String symbol, Duration window) {
                LocalDateTime now = LocalDateTime.now();
                // Mistake: Using activeTransactions instead of historicalData
                return activeTransactions.stream()
                        .filter(transaction -> transaction.getSymbol().equals(symbol) &&
                                Duration.between(transaction.getTimestamp(), now).compareTo(window) <= 0)
                        .mapToDouble(Transaction::getAmount)
                        .sum();
            }
        }

        // The Main method to demonstrate the  functionality
        public static void main(String[] args) {
            TradingProcessor tradingProcessor = new TradingProcessor();

            // Processing some transactions
            tradingProcessor.processTransaction(new Transaction(1L, "URBAN", 150.0, TransactionType.BUY));
            tradingProcessor.processTransaction(new Transaction(2L, "URBAN", 200.0, TransactionType.SELL));
            tradingProcessor.processTransaction(new Transaction(3L, "EDGE", 300.0, TransactionType.BUY));

            // Rollback a transaction
            tradingProcessor.rollbackTransaction(2L);

            // Get transactions in the last 5 minutes
            Iterator<Transaction> recentTransactions = tradingProcessor.getTransactionsByTimeWindow(Duration.ofMinutes(5));
            System.out.println("Recent Transactions:");
            while (recentTransactions.hasNext()) {
                Transaction transaction = recentTransactions.next();
                System.out.println("Transaction ID: " + transaction.getTransactionId() + ", Amount: " + transaction.getAmount());
            }

            // Get aggregate amount for URBAN in the last 5 minutes
            double aggregateAmount = tradingProcessor.getAggregateAmount("URBAN", Duration.ofMinutes(5));
            System.out.println("Aggregate Amount for URBAN: " + aggregateAmount);
        }
    }



