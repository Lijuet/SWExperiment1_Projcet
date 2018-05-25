package Components;

public class Person {
	protected String name;
	protected String emailAddress;
	protected String phoneNumber;
	
	//constructor
	Person(String name, String emailAddress, String phoneNumber) {
		this.name = name;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}
	
	//getter and setter of fields
	public String getName() { return name; }
	public String getEmailAddress() { return emailAddress; }
	public String getPhoneNumber() { return phoneNumber; }
	
	public void setName(String name) { this.name = name; }
	public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	
}
