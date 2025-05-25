package lab.unipi.gui.JavaFXLab;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Κλάση που αναπαριστά έναν δανεισμό βιβλίου από φοιτητή
public class Loan {

    private String id; // Κωδικός δανεισμού
    private Student student; // Ο φοιτητής που δανείζεται το βιβλίο
    private Book book; // Το βιβλίο που δανείζεται
    private LocalDate loanDate; // Ημερομηνία δανεισμού
    private LocalDate dueDate; // Προθεσμία επιστροφής
    private LocalDate returnDate; // Ημερομηνία επιστροφής
    @SuppressWarnings("unused")
	private boolean isDelayed; // Αν υπήρξε καθυστέρηση
    private String status; // Κατάσταση δανεισμού (Ενεργη, Καθυστερημένη, Ολοκληρωμένη)
    private Fine fine; // Το πρόστιμο που ενδεχομένως προέκυψε
    private FeePolicy feePolicy; // Πολιτική καθορισμού προστίμου

    public Loan(String id, Student student, Book book, LocalDate loanDate, FeePolicy feePolicy) {
        this.id = id;
        this.student = student;
        this.book = book;
        this.loanDate = loanDate;
        this.dueDate = loanDate.plusDays(14); // Προθεσμία επιστροφής: 14 μέρες μετά το δανεισμό
        this.returnDate = null;
        this.isDelayed = false;
        this.status = "Active";
        this.fine = null;
        this.feePolicy = feePolicy;
    }

    // Μέθοδος που καλείται κατά την επιστροφή του βιβλίου
    public void returnBook(LocalDate actualReturnDate) {
        this.returnDate = actualReturnDate;

        // Έλεγχος αν υπάρχει καθυστέρηση
        if (actualReturnDate.isAfter(dueDate)) {
            isDelayed = true;
            status = "Overdue";
            int daysLate = (int) ChronoUnit.DAYS.between(dueDate, actualReturnDate);
            this.fine = new Fine(daysLate, this, feePolicy); // Δημιουργία προστίμου
        } else {
            status = "Completed";
            fine = null;
        }

        book.setAvailable(true); // Το βιβλίο γίνεται ξανά διαθέσιμο
    }

    // Επιστρέφει αν υπάρχει πρόστιμο
    public boolean hasFine() {
        return fine != null;
    }

    // Getters & Setters (JavaBeans) 

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

    // Gettes & Setters για TableView (PropertyValueFactory) 

    // Επιστρέφει το ονοματεπώνυμο του φοιτητή
    public String getStudentDisplayName() {
        if (student == null) return "";
        return student.getFirstName() + " " + student.getLastName();
    }

    // Επιστρέφει τον τίτλο του βιβλίου
    public String getBookDisplayTitle() {
        return book != null ? book.getTitle() : "";
    }

    // Επιστρέφει ημερομηνία δανεισμού ως String
    public String getLoanDateString() {
        return loanDate != null ? loanDate.toString() : "";
    }

    // Επιστρέφει ημερομηνία προθεσμίας ως String
    public String getDueDateString() {
        return dueDate != null ? dueDate.toString() : "";
    }

    // Επιστρέφει ημερομηνία επιστροφής ως String
    public String getReturnDateString() {
        return returnDate != null ? returnDate.toString() : "";
    }

    // Επιστρέφει το ποσό προστίμου ως String (ή κενό αν δεν υπάρχει)
    public String getFineAmountString() {
        return fine != null ? String.format("%.2f", fine.getAmount()) : "";
    }
}