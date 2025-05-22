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


    public LoanSceneCreator(double width, double height) {
        super(width, height);
    
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
}
