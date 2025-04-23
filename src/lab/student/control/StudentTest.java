package lab.student.control;

import lab.student.entity.Student;
import lab.student.exception.StudentGradeException;

public class StudentTest extends Student {

	public static void main(String[] args) {
		Student student = new Student("2023101010","김민수","컴퓨터공학",3);
		System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "학년");
		System.out.println("5학년으로 변경");
		try {
			student.setGrade(5);
		
		} catch (StudentGradeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
