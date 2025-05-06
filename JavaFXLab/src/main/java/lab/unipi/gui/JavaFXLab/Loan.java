package lab.unipi.gui.JavaFXLab;
import java.time.LocalDate; 
import java.time.temporal.ChronoUnit;

public class Loan {
	private String id;
	private User user;
	private Book book; 
	private LocalDate loanDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	private Fine fine; 
	
	public Loan(String id, User user, Book book, LocalDate loanDate, LocalDate dueDate) {
			this.id = id;
			this.user = user;
			this.book = book;
			this.loanDate = loanDate;
			this.dueDate = dueDate; 
			this.returnDate = null; 
			this.fine = null; 
		
	}
	public boolean Overdue() {
		return true;
	}
	
    // setters & getters
    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public Fine getFine() {
        return fine;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setFine(Fine fine) {
        this.fine = fine;
    }
	

}
