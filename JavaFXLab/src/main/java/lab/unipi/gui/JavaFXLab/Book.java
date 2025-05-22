package lab.unipi.gui.JavaFXLab;


import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String category;
    private boolean available;

    //Constructor
    public Book(String isbn, String title, String author, String publisher, int year, String category, boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.category = category;
        this.available = available;
    }

    //Getters
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public String getCategory() {
        return category;
    }

    public boolean getAvailable() {
        return available;
    }

    //Setters
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    //toString
    @Override
    public String toString() {
        return "ISBN: " + isbn + "\n" +
               "Title: " + title + "\n" +
               "Author: " + author + "\n" +
               "Publisher: " + publisher + "\n" +
               "Year: " + year + "\n" +
               "Category: " + category + "\n" +
               "Available: " + (available ? "Yes" : "No");
    }
	public static void addBook(ArrayList<Book> books, Scanner scanner) {
    	System.out.println("----- Προσθήκη Νέου Βιβλίου -----");
    	System.out.print("ISBN: ");
    	String isbn = scanner.nextLine();
    	System.out.print("Τίτλος: ");
    	String title = scanner.nextLine();
    	System.out.print("Συγγραφέας: ");
    	String author = scanner.nextLine();
    	System.out.print("Εκδότης: ");
    	String publisher = scanner.nextLine();
    	System.out.print("Έτος: ");
    	int year = Integer.parseInt(scanner.nextLine());
    	System.out.print("Κατηγορία: ");
    	String category = scanner.nextLine();

    	Book book = new Book(isbn, title, author, publisher, year, category, true);
    	books.add(book);

    	System.out.println("Το βιβλίο προστέθηκε με επιτυχία!");
	}
}
