package s8115.student;

import org.junit.Test;

public class StudentTest {

	@Test
	public void saveTest() {

		StudentOperacje studentOperacje = new StudentOperacje();

		Student s = new Student();
		s.setImie("Marek");
		s.setNazwisko("Nowak");
		s.setPesel("1234325678");
		s.setTelefon("674893095");

		studentOperacje.saveStudent(s);
	}
}
