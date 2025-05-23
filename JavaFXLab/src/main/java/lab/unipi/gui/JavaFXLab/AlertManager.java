package lab.unipi.gui.JavaFXLab;

import javafx.scene.control.Alert;

public class AlertManager {
	
	public static void infoAlert(String title, String message) {
			Alert alertType = new Alert(Alert.AlertType.INFORMATION); //enhmerwtiko text gia mia katastash
			alertType.setTitle(title);
			alertType.setContentText(message);
			alertType.show();
		}
	
	public static void specificAlert(String e) {
			Alert alertType = new Alert(Alert.AlertType.ERROR); //το συστημα βγαζει error αν υπάρξει λαθος input, ή κατι unexpected
			alertType.setTitle("Invalid value");
			alertType.setContentText("Invalid input type. \n Exception message: "+ e);
			alertType.show();
		}
	
	public static void unexpectedAlert() {
			Alert alertType = new Alert(Alert.AlertType.ERROR);//error για περιπτώσεις που δεν προβλέπονται
			alertType.setTitle("Error");
			alertType.setContentText("An unexpected Error occured");
			alertType.show();
		}

	}

