public class Book extends LibraryItem {
    private String author;
    private String isbn;
    private double lateFeePerDay;

    public Book(String id, String title, String author, String isbn) {
        super(id, title);
        this.author = author;
        this.isbn = isbn;
        this.lateFeePerDay = 2.0;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * lateFeePerDay;
    }
}