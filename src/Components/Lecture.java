package Components;

import ManageFunction.Delete;
import ManageFunction.Modify;
import ManageFunction.Reader;
import ManageFunction.Writer;
import java.util.ArrayList;
import java.util.HashMap;

public class Lecture implements HandlingStudents{
	protected String name;//name of Lecture
	protected Professor professor;//list of professor
	protected HashMap<Integer ,Student> list_student;//hashmap<studentId, Student object>
	
	//constructor
	public Lecture(String name){ 
		this.name = name.trim();
		professor = new Professor(null, null, null);
		list_student = new HashMap<>();	
	}

	//getter and setter of fields
	public int numOfStudent;
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Professor getProfessor() { return professor; }

	//read Lecture.csv and find the professor according to class
	public void setProfessor(String lectureName)	{
		Reader a = new Reader("Lecture.csv");
		professor = a.professorReader(lectureName);
	}

	public void setStudent(ArrayList<Student> students)
	{
		for(int i = 0; i < students.size(); i++)
		{
			list_student.put(students.get(i).getStudentId(), students.get(i));
		}
		numOfStudent = students.size();
	}

	public HashMap<Integer ,Student> readStudentListFile(String path) {
		/* copy students Information form file which connected with path
		 * make Student instance
		 * add it to list_student
		 * */
		return null;
	}
	
	public void addStudent(Student newStudent) {
		//read information from frame
		Integer studentId = newStudent.getStudentId();
		
		if(!list_student.containsKey(studentId)) {//there is no student with same student id
			list_student.put(studentId, newStudent);
			/*******Add Student in CSV file******/
			Writer a = new Writer(name + "_StudentInfo.csv");
			a.studentWriter(newStudent);
			/***********************************/
			// System.out.println("We add Student " + newStudent.getName() + "( " + String.valueOf(newStudent.getStudentId()) + " ) information.");
		}else {//when there is already student with input student Id
			// System.out.println("There is already student with " + String.valueOf(newStudent.getStudentId()));
		}
	}
	
	public void deleteStudent(int studentId) {
		//read information from view
		if(list_student.containsKey(studentId)) {//there is no student with same student id
			Student temp = (Student)list_student.get(studentId);
			list_student.remove(studentId);
			/*******Delete Student in CSV file******/
			Delete a = new Delete(name + "_StudentInfo.csv");
			a.studentDelete(studentId);
			/***********************************/
			//info delete by popup
			System.out.println("We delete Student " + temp.getName() +
							   "( " + String.valueOf(studentId) + " ) inforamtion.");
		}else {//when there is no student with input student Id
			System.out.println("There is no such student with " + String.valueOf(studentId));
		}		
	}
	
	public String searchStudent(int studentId) {
		//read information from view
		String studentInfo = null;
		if(list_student.containsKey(studentId)) {//there is no student with same student id
			Student temp = (Student)list_student.get(studentId);
			studentInfo = "Student name: " + temp.getName() + "\n" + "Student Id: " + studentId + "\n" + "Email: " + temp.getEmailAddress()
					+ "\n" + "Phone number: " + temp.getPhoneNumber();
			return studentInfo;
		}else {//when there is no student with input student Id
			// System.out.println("There is no such student with " + String.valueOf(studentId))
			studentInfo = "There is no such student with " + String.valueOf(studentId);
		}
		return studentInfo;
	}

	public int existStudent(int studentId)	{
		if(list_student.containsKey(studentId)) { return 1; }
		else { return 0; }
	}


	public Student modifyStudentName(int studentId, String change) {
		//read information from view
		if(list_student.containsKey(studentId)) {//there is no student with same student id
			Student temp = (Student)list_student.get(studentId);
			temp.setName(change);// modify temp's name
			list_student.remove(studentId);
			list_student.put(studentId, temp);
			// store modified student information
			/*******Modify Student in CSV file******/
			Modify a = new Modify(studentId, name + "_StudentInfo.csv");
			a.modifyName(change);
			/***************************************/
			return temp;
		}else {//when there is no student with input student Id
			System.out.println("There is no such student with " + String.valueOf(studentId));
			return null;
		}
	}

	public Student modifyStudentID(int studentId, String change) {
		//read information from view
		if(list_student.containsKey(studentId)) {
			Student temp = (Student)list_student.get(studentId);
			temp.setStudentId(Integer.parseInt(change));// modify temp's Id
			list_student.remove(studentId);
			list_student.put(Integer.parseInt(change), temp);
			// store modified student information
			/*******Modify Student in CSV file******/
			Modify a = new Modify(studentId, name + "_StudentInfo.csv");
			a.modifyStudentNumber(change);
			/***************************************/

			return temp;
		}else {//when there is no student with input student Id
			System.out.println("There is no such student with " + String.valueOf(studentId));
			return null;
		}
	}

	public Student modifyStudentEmail(int studentId, String change) {
		//read information from view

		if(list_student.containsKey(studentId)) {
			Student temp = (Student)list_student.get(studentId);
			temp.setEmailAddress(change);// modify temp's emailAddress
			list_student.remove(studentId);
			list_student.put(studentId, temp);
			// store modified student information
			/*******Modify Student in CSV file******/
			Modify a = new Modify(studentId, name + "_StudentInfo.csv");
			a.modifyMail(change);
			/***************************************/

			return temp;
		}else {//when there is no student with input student Id
			System.out.println("There is no such student with " + String.valueOf(studentId));
			return null;
		}
	}

	public Student modifyStudentNumber(int studentId, String change) {
		//read information from view

		if(list_student.containsKey(studentId)) {
			Student temp = (Student)list_student.get(studentId);
			temp.setPhoneNumber(change);// modify temp's phone number
			list_student.remove(studentId);
			list_student.put(studentId, temp);
			// store modified student information
			/*******Modify Student in CSV file******/
			Modify a = new Modify(studentId, name + "_StudentInfo.csv");
			a.modifyStudentNumber(change);
			/***************************************/

			return temp;
		}else {//when there is no student with input student Id
			System.out.println("There is no such student with " + String.valueOf(studentId));
			return null;
		}
	}
}
