package lab.student.control;

import lab.student.entity.Student;
import lab.student.exception.StudentGradeException;

public class StudentTest extends Student {

	public static void main(String[] args) {
		Student student = new Student("2023101010","��μ�","��ǻ�Ͱ���",3);
		System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "�г�");
		System.out.println("5�г����� ����");
		try {
			student.setGrade(5);
		
		} catch (StudentGradeException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
