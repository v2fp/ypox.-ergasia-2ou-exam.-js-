package lab.unipi.gui.JavaFXLab;

import javafx.scene.control.Alert;

public class AlertManager {
	
	public static void infoAlert(String title, String message) {
			Alert alertType = new Alert(Alert.AlertType.INFORMATION); //το συστημα βγαζει error αν υπάρξει λαθος input, ή κατι unexpected
			alertType.setTitle(title);
			alertType.setContentText(message);
			alertType.show();
		}
	
	public static void specificAlert(String e) {
			Alert alertType = new Alert(Alert.AlertType.ERROR);
			alertType.setTitle("Invalid value");
			alertType.setContentText("Invalid input type. \n Exception message: "+ e);
			alertType.show();
		}
	
	public static void unexpectedAlert() {
			Alert alertType = new Alert(Alert.AlertType.ERROR);
			alertType.setTitle("Error");
			alertType.setContentText("An unexpected Error occured");
			alertType.show();
		}

	}


