package Components;

public class Professor extends Person{

	public Professor(String name, String emailAddress, String phoneNumber) {
		super(name, emailAddress, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	protected String specialty;
	protected String officeLocation;
	//NOTICE : private Time officeTime; Let's handle this Time Type after finish other.
	
	//getter and setter of fields
	public String getSpecialty() { return specialty; }
	public String getOfficLocation() { return officeLocation; }
	
	public void setSpecialty(String specialty) { this.specialty = specialty; }
	public void setOfficeLocation(String officeLocation) { this.officeLocation = officeLocation; }

	
	
}
