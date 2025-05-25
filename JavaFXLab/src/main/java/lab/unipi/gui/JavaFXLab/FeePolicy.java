package lab.unipi.gui.JavaFXLab;

// Κλάση που ορίζει την πολιτική υπολογισμού προστίμων
public class FeePolicy {
    private double dailyRate; // Ημερήσιο ποσό προστίμου
    private double maxFine;   // Μέγιστο ποσό προστίμου

    public FeePolicy(double dailyRate, double maxFine) {
         this.dailyRate = dailyRate;
         this.maxFine = maxFine;
    }

    // Υπολογισμός προστίμου με βάση τις ημέρες καθυστέρησης
    public double calculateFine(int overdueDays) {
        double fine = overdueDays * dailyRate;
        return Math.min(fine, maxFine); // Το πρόστιμο δεν ξεπερνά το μέγιστο
    }

    // Setters & getters

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getMaxFine() {
        return maxFine;
    }

    public void setMaxFine(double maxFine) {
        this.maxFine = maxFine;
    }
}