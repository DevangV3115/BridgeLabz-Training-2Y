interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    public LibraryItem(int id, String title, String author) {
        this.itemId = id;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}

class Book extends LibraryItem implements Reservable {
    public Book(int id, String title, String author) { super(id, title, author); }
    public int getLoanDuration() { return 14; }
    public void reserveItem() { System.out.println("Book Reserved"); }
    public boolean checkAvailability() { return true; }
}

class Magazine extends LibraryItem implements Reservable {
    public Magazine(int id, String title, String author) { super(id, title, author); }
    public int getLoanDuration() { return 7; }
    public void reserveItem() { System.out.println("Magazine Reserved"); }
    public boolean checkAvailability() { return true; }
}

class DVD extends LibraryItem implements Reservable {
    public DVD(int id, String title, String author) { super(id, title, author); }
    public int getLoanDuration() { return 3; }
    public void reserveItem() { System.out.println("DVD Reserved"); }
    public boolean checkAvailability() { return true; }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book(1, "Java Basics", "James"),
            new Magazine(2, "Tech Today", "Editor"),
            new DVD(3, "Avengers", "Marvel")
        };

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
        }
    }
}
