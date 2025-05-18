package lab.unipi.gui.JavaFXLab;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class BookSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	// Flow Pane (root mode
    FlowPane rootFlowPane;
    // Main scene buttons
    Button backBtn, newbookBtn, editbookBtn, deletebookBtn;
	
    public BookSceneCreator(double width, double height) {
    	super(width, height);
        rootFlowPane = new FlowPane();
        backBtn = new Button("Διαχείριση Βιβλίων");
        newbookBtn = new Button("Καταχώρηση νέου βιβλίου");
        editbookBtn = new Button("Επεξεργασία Στοιχείων Βιβλίου");
        deletebookBtn = new Button("Αφαίρεση Βιβλίου");    
    }

    @Override
    Scene createScene() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void handle(MouseEvent event) {
        // TODO Auto-generated method stub
        
    }

}