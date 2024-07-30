import java.util.*;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManagementSystem {

    // Linear search to find books by title
    public static Book linearSearch(List<Book> books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; // Book not found
    }

    // Binary search to find books by title
    public static Book binarySearch(List<Book> books, String title) {
        int left = 0;
        int right = books.size() - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books.get(mid).title.compareToIgnoreCase(title);

            if (comparison == 0) {
                return books.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Book not found
    }

    // Helper method to print the search result
    public static void printSearchResult(Book book) {
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "Moby Dick", "Herman Melville"));
        books.add(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(4, "1984", "George Orwell"));
        books.add(new Book(5, "Pride and Prejudice", "Jane Austen"));

        // Sort the list for binary search
        books.sort(Comparator.comparing(book -> book.title));

        System.out.println("Linear Search:");
        printSearchResult(linearSearch(books, "Pride and Prejudice"));

        System.out.println("\nBinary Search:");
        printSearchResult(binarySearch(books, "Moby Dick"));
    }
}
