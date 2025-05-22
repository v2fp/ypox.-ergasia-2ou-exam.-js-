package lab.unipi.gui.JavaFXLab;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String birthDate;

	public User() {
		// TODO Auto-generated constructor stub
	}
    //Constructor
    public User(int id, String firstName, String lastName, String phone, String email, String birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.birthDate = birthDate;
    }
    //Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }
  //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
  //toString
    @Override
    public String toString() {
        return "User ID: " + id + "\n" +
               "Name: " + firstName + " " + lastName + "\n" +
               "Phone: " + phone + "\n" +
               "Email: " + email + "\n" +
               "Birth Date: " + birthDate;
    }
}