package lab.unipi.gui.JavaFXLab;

import java.time.Year;
import java.util.regex.Pattern;
@SuppressWarnings("unused")

public class CheckValidity {

	//check email
	public static boolean emailValidity(String email) {
		Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		return pattern.matcher(email).matches();
	}
	//check isbn
	public static boolean checkIsbn(String isbn) {
		int check;
			isbn = isbn.replace("-", "").trim(); //αφαιρούμε τις παύλες και ελεγχουμε αν ειναι 13 τα ψηφια
			int Length = isbn.length();
			if(Length != 13) {				
				return false;
			}
			for(char c: isbn.toCharArray()){//ελεγχουμε αν περιεχει μονο ψηφια και οχι χαρακτηρες
				if(!Character.isDigit(c)) {
			}
		}
		return true;
	}

	//check phone
	public static boolean checkPhone(String phone) { 
		if((phone == null || phone.isEmpty()) && phone.length() != 10) {
			return false;
		}
		return phone.chars().allMatch(Character::isDigit);
	}
	
	//check year 1600 - σημερα
	public static boolean yearValidity(int year) {
		if(year >1600 && year <= Year.now().getValue()) {
			return true;
		}else return false;
	}

}
