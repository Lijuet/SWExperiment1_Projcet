package Components;

public class Professor extends Person{

	public Professor(String name, String emailAddress, String phoneNumber) {
		super(name, emailAddress, phoneNumber);
	}

	protected String specialty;
	protected String officeLocation;
	
	//getter and setter of fields
	public String getSpecialty() { return specialty; }
	public String getOfficLocation() { return officeLocation; }
	
	public void setSpecialty(String specialty) { this.specialty = specialty; }
	public void setOfficeLocation(String officeLocation) { this.officeLocation = officeLocation; }

	
	
}
