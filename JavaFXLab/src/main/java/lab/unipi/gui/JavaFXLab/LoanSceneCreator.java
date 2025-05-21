package lab.unipi.gui.JavaFXLab;

import javafx.scene.input.MouseEvent;

import java.time.LocalDate;

import javafx.event.EventHandler;
import javafx.scene.Scene;

public class LoanSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	    private String id;
	    private User user;
	    private Book book;
	    private LocalDate loanDate;
	    private LocalDate dueDate;
	    private LocalDate returnDate;
	    private boolean isDelayed;
	    private String status; // Active, Completed, Overdue
	    private Fine fine;


    public LoanSceneCreator(double 650, double 300) {
        super(650, 300);
    
    }

    @Override
    Scene createScene() {
        this.loanDate = LocalDate.now();
        this.dueDate = loanDate.plusDays(14);
        this.status = "Active";
        this.isDelayed = false;
        this.returnDate = null;
        this.fine = null;

        return null;
    }
    @Override
    public void handle(MouseEvent event) {
        this.returnDate = LocalDate.now();
        if (returnDate.isAfter(dueDate)) {
            this.isDelayed = true;
            this.status = "Overdue";
            long daysLate = java.time.temporal.ChronoUnit.DAYS.between(dueDate, returnDate);
            this.fine = new Fine(daysLate);
        } else {
            this.isDelayed = false;
            this.status = "Completed";
            this.fine = null;
        }
    }


    // setters & getters
    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
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

    public boolean isDelayed() {
        return isDelayed;
    }

    public String getStatus() {
        return status;
    }

    public Fine getFine() {
        return fine;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
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

    public void setDelayed(boolean isDelayed) {
        this.isDelayed = isDelayed;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFine(Fine fine) {
        this.fine = fine;
    }

}