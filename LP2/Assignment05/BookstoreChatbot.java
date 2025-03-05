import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookstoreChatbot {
    private static final Map<String, Book> bookInventory = new HashMap<>();

    static class Book {
        String name;
        double price;
        boolean isAvailable;

        Book(String name, double price, boolean isAvailable) {
            this.name = name;
            this.price = price;
            this.isAvailable = isAvailable;
        }
    }

    public static void main(String[] args) {
        initializeBooks();
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Welcome to the Bookstore Chatbot! Ask me about books.");
        while (true) {
            System.out.print("\nYou: ");
            String query = scanner.nextLine().trim().toLowerCase();

            if (query.equals("exit")) {
                System.out.println("Goodbye! Have a great day. ");
                break;
            }

            handleQuery(query);
        }
        scanner.close();
    }

    private static void initializeBooks() {
        bookInventory.put("harry potter", new Book("Harry Potter", 499.99, true));
        bookInventory.put("lord of the rings", new Book("Lord of the Rings", 799.99, false));
        bookInventory.put("the alchemist", new Book("The Alchemist", 299.50, true));
        bookInventory.put("rich dad poor dad", new Book("Rich Dad Poor Dad", 399.00, true));
        bookInventory.put("1984", new Book("1984", 350.75, false));
    }

    private static void handleQuery(String query) {
        if (query.contains("book") || query.contains("list")) {
            System.out.println("Available books: " + bookInventory.keySet());
            return;
        }

        if (query.startsWith("issue ")) {
            String bookName = query.replace("issue ", "").trim();
            issueBook(bookName);
            return;
        }

        for (String bookName : bookInventory.keySet()) {
            if (query.contains(bookName)) {
                Book book = bookInventory.get(bookName);
                System.out.println(book.name + " - ₹" + book.price);
                if (book.isAvailable) {
                    System.out.println("Available for issuing. Type 'issue " + bookName + "' to get it.");
                } else {
                    System.out.println(" Currently out of stock.");
                }
                return;
            }
        }

        

        System.out.println("Sorry, I didn't understand that. Try asking about a book.");
    }

    private static void issueBook(String bookName) {
        if (!bookInventory.containsKey(bookName)) {
            System.out.println("This book is not in our inventory.");
            return;
        }

        Book book = bookInventory.get(bookName);
        if (!book.isAvailable) {
            System.out.println(" Sorry, " + book.name + " is out of stock.");
        } else {
            book.isAvailable = false;
            System.out.println("You have successfully issued " + book.name + ". Enjoy your reading!");
        }
    }
}
