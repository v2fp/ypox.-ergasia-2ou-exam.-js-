package lab.unipi.gui.JavaFXLab;

public class FeePolicy {
	private double dailyRate;
	private double maxFine;
	public FeePolicy(double dailyRate, double maxFine) {
		 this.dailyRate = dailyRate;
	     this.maxFine = maxFine;
	}
	
	  public double calculateFine(int overdueDays) {
	        double fine = overdueDays * dailyRate;
	        return Math.min(fine, maxFine);
	    }
	    // setters & getters
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