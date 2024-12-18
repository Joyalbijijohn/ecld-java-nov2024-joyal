import java.time.LocalDate;

    public class Magazine extends LibraryItem {
        private LocalDate issueDate;
        private String publisher;
        private double lateFeePerDay;

        public Magazine(String id, String title, LocalDate issueDate, String publisher) {
            super(id, title);
            this.issueDate = issueDate;
            this.publisher = publisher;
            this.lateFeePerDay = 1.0;
        }

        @Override
        public double calculateLateFee(int daysLate) {
            return daysLate * lateFeePerDay;
        }
    }


