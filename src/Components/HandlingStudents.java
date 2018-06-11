package Components;

import java.util.HashMap;

public interface HandlingStudents {
	public HashMap<Integer, Student> readStudentListFile(String path);
	public void addStudent(Student newStudent);
	public void deleteStudent(int studentId);
	public String searchStudent(int studentId);
	
	//NOTICE : e-mail function needs to be separated with this interface 
}