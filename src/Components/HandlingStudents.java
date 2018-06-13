package Components;

public interface HandlingStudents {//functions which need to be overloaded
	void addStudent(Student newStudent);
	void deleteStudent(int studentId);
	String searchStudent(int studentId);
}