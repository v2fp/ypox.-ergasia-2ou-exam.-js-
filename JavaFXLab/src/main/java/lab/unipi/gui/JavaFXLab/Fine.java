package lab.unipi.gui.JavaFXLab;

public class Fine {
    private static int counter = 1;

    private int id;
    private Loan loan;
    private double amount;
    private String paymentStatus; // Pending, Paid
    private FeePolicy feePolicy;

    public Fine(int overdueDays, Loan loan, FeePolicy feePolicy) {
        this.id = counter++;
        this.loan = loan;
        this.feePolicy = feePolicy;
        this.amount = feePolicy.calculateFine(overdueDays);
        this.paymentStatus = "Pending";
    }

    public void markAsPaid() {
        this.paymentStatus = "Paid";
    }

    // Getters & setters
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

    public FeePolicy getFeePolicy() {
        return feePolicy;
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

    public void setFeePolicy(FeePolicy feePolicy) {
        this.feePolicy = feePolicy;
    }
}