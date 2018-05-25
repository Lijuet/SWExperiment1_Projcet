import java.util.Scanner;

import Components.*;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name = s.next();
		int Id = s.nextInt();
		
		s.close();
		
		Lecture SP = new Lecture("SystemProgramming");
		
		SP.addStudent(new Student(name,null,null,Id));
		SP.addStudent(new Student("test1",null,null,1));
		SP.addStudent(new Student("test1",null,null,2));
		
		SP.searchStudent(2);
		
		SP.deleteStudent(2);
		SP.searchStudent(2);
		
		
	}

}
