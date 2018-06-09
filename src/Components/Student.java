package Components;

public class Student extends Person{
	protected int studentId;
	
	//constructor
	public Student(String name, String emailAddress, String phoneNumber, int studentId) {
		super(name, emailAddress, phoneNumber);
		this.studentId = studentId;
	}
	
	//getter and setter of fields
	public int getStudentId() { return studentId; }
	public String getEmailAddress() { return emailAddress; }
	public String getPhoneNumber() { return phoneNumber; }
	public String getName() { return name; }
	
	public void setStudentId(int studentId) { this.studentId = studentId; }

}
