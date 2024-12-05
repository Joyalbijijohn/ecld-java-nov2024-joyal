import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Library {

        private List<LibraryItem> items;

        public Library() {
            this.items = new ArrayList<>();
        }

        public void addItem(LibraryItem item) {
            items.add(item);
        }

        public void removeItem(String id) {
            items.removeIf(item -> item.getId().equals(id));
        }

        public List<LibraryItem> searchByTitle(String title) {
            return items.stream()
                    .filter(item -> item.getTitle().equalsIgnoreCase(title))
                    .collect(Collectors.toList());
        }

        public Optional<LibraryItem> borrowItem(String id) {
            for (LibraryItem item : items) {
                if (item.getId().equals(id) && item.isAvailable()) {
                    item.setAvailable(false);
                    return Optional.of(item);
                }
            }
            return Optional.empty();
        }

        public void returnItem(String id) {
            for (LibraryItem item : items) {
                if (item.getId().equals(id)) {
                    item.setAvailable(true);
                    return;
                }
            }
        }

        public List<LibraryItem> getOverdueItems(int daysOverdue) {
            return new ArrayList<>();
        }
    }

