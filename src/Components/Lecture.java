package Components;

import ModifyFiles.Delete;
import ModifyFiles.Writer;
import java.util.ArrayList;
import java.util.HashMap;

public class Lecture implements HandlingStudents{
	protected String name;//name of Lecture
	protected ArrayList<Professor> list_professor;//list of professor
	protected HashMap<Integer ,Student> list_student;//hashmap<studentId, Student object>
	
	//constructor
	public Lecture(String name){ 
		this.name = name;
		list_professor = new ArrayList<>();
		list_student = new HashMap<>();	
	}
	
	//getter and setter of fields
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	

	public HashMap<Integer ,Student> readStudentListFile(String path) {
		/* copy students Information form file which connected with path
		 * make Student instance
		 * add it to list_student
		 * */
		return null;
	}
	
	public void addStudent(Student newStudent) {
		//read information from view 
		
		Integer studentId = newStudent.getStudentId();
		
		if(!list_student.containsKey(studentId)) {
			list_student.put(studentId, newStudent);
			//info add by popup
			/*******학생을 csv파일에서도 추가******/
			Writer a = new Writer();
			a.studentWriter(newStudent);
			/***********************************/
			System.out.println("We add Student " + newStudent.getName() + "( " + String.valueOf(newStudent.getStudentId()) + " ) information.");
		}else {//when there is already student with input student Id
			System.out.println("There is already student with " + String.valueOf(newStudent.getStudentId()));
		}
	}
	
	public void deleteStudent(int studentId) {
		//read information from view 
		
		if(list_student.containsKey(studentId)) {
			Student temp = (Student)list_student.get(studentId);
			list_student.remove(studentId);
			/*******학생을 csv파일에서도 삭제******/
			Delete a = new Delete();
			a.studentDelete(studentId);
			/***********************************/
			
			//info delete by popup
			System.out.println("We delete Student " + temp.getName() +
							   "( " + String.valueOf(studentId) + " ) inforamtion.");
		}else {//when there is no student with input student Id
			System.out.println("There is no such student with " + String.valueOf(studentId));
		}		
	}
	
	public Student searchStudent(int studentId) {
		//read information from view 
		
		if(list_student.containsKey(studentId)) {
			Student temp = (Student)list_student.get(studentId);
			
			//info delete by popup
			System.out.println("Student name: " + temp.getName());
			System.out.println("Student Id: " + studentId);
			System.out.println("Student e-mail: " + temp.getEmailAddress());
			System.out.println("Student phone: " + temp.getPhoneNumber());

			return temp;
		}else {//when there is no student with input student Id
			System.out.println("There is no such student with " + String.valueOf(studentId));
			return null;
		}
	}
}
