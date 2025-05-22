package lab.unipi.gui.JavaFXLab;

public class Fine {

    private static int counter = 1;

    private int id;
    private Loan loan;
    private double amount;
    private String paymentStatus; // Pending, Paid

    public Fine(int overdueDays, Loan loan) {
        this.id = counter++;
        this.loan = loan;
        this.amount = calculateFine(overdueDays);
        this.paymentStatus = "Pending";
    }

	public double calculateFine(int overdueDays) {
        // 1€ per day, maximum 10€
        return Math.min(10.0, overdueDays);
    }

    public void markAsPaid() {
        this.paymentStatus = "Paid";
    }

    // setters & getters
    public int getId() {
        return id;
    }

    public Loan getLoan() {
        return loan;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
