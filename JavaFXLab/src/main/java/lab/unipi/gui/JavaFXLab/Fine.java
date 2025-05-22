package lab.unipi.gui.JavaFXLab;
import java.time.LocalDate;

public class Fine {
	private double amount;
	private Loan loan;
	private boolean paid;
	private LocalDate issuedDate;
	private LocalDate paymentDate;
	
	public Fine(double amount, Loan loan) {
        this.amount = amount;
        this.loan = loan;
        this.paid = false;
        this.issuedDate = LocalDate.now();
		
	}
	
	   public void markAsPaid() {
	        this.paid = true;
	        this.paymentDate = LocalDate.now();
	    }

	    public boolean isPaid() {
	        return paid;
	    }
    private static int counter = 1;

    private int id;
    private String paymentStatus; // Pending, Paid

	    // setters & getters
	    public double getAmount() {
	        return amount;
	    }
    public Fine(int overdueDays, Loan loan) {
        this.id = counter++;
        this.loan = loan;
        this.amount = calculateFine(overdueDays);
        this.paymentStatus = "Pending";	       
}

<<<<<<< HEAD
	public double calculateFine(int overdueDays) {
=======
	    public Loan getLoan() {
	        return loan;
	    }
    public double calculateFine(int overdueDays) {
>>>>>>> 84e52ed1d378c566c5078c01153cf5bd1832d62f
        // 1€ per day, maximum 10€
        return Math.min(10.0, overdueDays);
    }

	    public LocalDate getIssuedDate() {
	        return issuedDate;
	    }

	    public LocalDate getPaymentDate() {
	        return paymentDate;
	    }
    // setters & getters
    public int getId() {
        return id;
    }

	    public void setIssuedDate(LocalDate issuedDate) {
this.issuedDate = issuedDate;
	    }
    public String getPaymentStatus() {
        return paymentStatus;
    }

	    public void setPaymentDate(LocalDate paymentDate) {
	        this.paymentDate = paymentDate;
	    }
    public void setLoan(Loan loan) {
        this.loan = loan;
    }

	    public void setPaid(boolean paid) {
	        this.paid = paid;
	    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
