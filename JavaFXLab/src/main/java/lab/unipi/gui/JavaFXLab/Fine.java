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

	    // setters & getters
	    public double getAmount() {
	        return amount;
	    }

	    public Loan getLoan() {
	        return loan;
	    }

	    public LocalDate getIssuedDate() {
	        return issuedDate;
	    }

	    public LocalDate getPaymentDate() {
	        return paymentDate;
	    }

	    public void setAmount(double amount) {
	        this.amount = amount;
	    }

	    public void setLoan(Loan loan) {
	        this.loan = loan;
	    }

	    public void setIssuedDate(LocalDate issuedDate) {
	        this.issuedDate = issuedDate;
	    }

	    public void setPaymentDate(LocalDate paymentDate) {
	        this.paymentDate = paymentDate;
	    }

	    public void setPaid(boolean paid) {
	        this.paid = paid;
	    }

}
