package lab.unipi.gui.JavaFXLab;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String category;
    private boolean isAvailable;

    //Constructor
    public Book(String isbn, String title, String author, String publisher, int year, String category, boolean isAvailable) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.category = category;
        this.isAvailable = isAvailable;
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

    public boolean isAvailable() {
        return isAvailable;
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

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
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
               "Available: " + (isAvailable ? "Yes" : "No");
    }
 
}

