
package lab.unipi.gui.JavaFXLab;

public class Librarian extends User{
    private String workDepartment;
    private String educationLevel;

	public Librarian() {
		// TODO Auto-generated constructor stub
	}
        // Constructor
        public Librarian(int id, String firstName, String lastName, String phone, String email, String birthDate,
                         String workDepartment, String educationLevel) {
            super(id, firstName, lastName, phone, email, birthDate);
            this.workDepartment = workDepartment;
            this.educationLevel = educationLevel;
        }
        // Getters
        public String getWorkDepartment() {
            return workDepartment;
        }

        public String getEducationLevel() {
            return educationLevel;
        }

        // Setters
        public void setWorkDepartment(String workDepartment) {
            this.workDepartment = workDepartment;
        }

        public void setEducationLevel(String educationLevel) {
            this.educationLevel = educationLevel;
        }
    }