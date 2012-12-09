package s8115.student;

import org.junit.Assert;
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
	
	@Test
	public void findStudentTest() {

		StudentOperacje studentOperacje = new StudentOperacje();

		Student s = studentOperacje.findStudentById(4L);

		Assert.assertNotNull(s);
		Assert.assertEquals("Ania", s.getImie());
		
		
	}
}
