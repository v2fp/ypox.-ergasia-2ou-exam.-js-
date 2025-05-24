package lab.unipi.gui.JavaFXLab;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
@SuppressWarnings("unused") 
public class Loan {

    private String id;
    private Student student;
    private Book book;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean isDelayed;
    private String status; // Active, Completed, Overdue
    private Fine fine;
    private FeePolicy feePolicy;

    public Loan(String id, Student student, Book book, LocalDate loanDate, FeePolicy feePolicy) {
        this.id = id;
        this.student = student;
        this.book = book;
        this.loanDate = loanDate;
        this.dueDate = loanDate.plusDays(14);
        this.returnDate = null;
        this.isDelayed = false;
        this.status = "Active";
        this.fine = null;
        this.feePolicy = feePolicy;
    }
    
	// Method called when a book is returned
    public void returnBook(LocalDate actualReturnDate) {
        this.returnDate = actualReturnDate;

        if (actualReturnDate.isAfter(dueDate)) {
            isDelayed = true;
            status = "Overdue";
            int daysLate = (int) ChronoUnit.DAYS.between(dueDate, actualReturnDate);
            this.fine = new Fine(daysLate, this, feePolicy);
        } else {
            status = "Completed";
            fine = null;
        }

        book.setAvailable(true); // Update book availability
    }

    public boolean hasFine() {
        return fine != null;
    }

    // getters & setters
    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
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

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public FeePolicy getFeePolicy() {
        return feePolicy;
    }

    public void setFeePolicy(FeePolicy feePolicy) {
        this.feePolicy = feePolicy;
    }
    public String getStudentDisplayName() {
        if (student == null) return "";
        return student.getFirstName() + " " + student.getLastName();
    }

    public String getBookDisplayTitle() {
        return book != null ? book.getTitle() : "";
    }

    public String getLoanDateString() {
        return loanDate != null ? loanDate.toString() : "";
    }

    public String getDueDateString() {
        return dueDate != null ? dueDate.toString() : "";
    }

    public String getReturnDateString() {
        return returnDate != null ? returnDate.toString() : "";
    }

    public String getFineAmountString() {
        return fine != null ? String.format("%.2f", fine.getAmount()) : "";
    }
}
