// Junit klasa ktora wykonuje testy

package s8115.student;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

	@Test // testuje zapis
	public void saveTest() {

		StudentOperacje studentOperacje = new StudentOperacje();

		Student s = new Student();
		s.setImie("Marek");
		s.setNazwisko("Nowak");
		s.setPesel("1234325678");
		s.setTelefon("674893095");

		studentOperacje.saveStudent(s);
	}
	
	@Test // testuje wyszukanie rekordu po Id
	public void findStudentTest() {

		StudentOperacje studentOperacje = new StudentOperacje();

		Student s = studentOperacje.findStudentById(5L);

		Assert.assertNotNull(s);
		Assert.assertEquals("Ania", s.getImie());
		
		
	}
	
	
	@Test  // testuje wyszukanie liste studentow
	public void findListStudentTest() {

		StudentOperacje studentOperacje = new StudentOperacje();

		List<Student>ListaStudent = studentOperacje.findAllStudent();
		
		for(Student s : ListaStudent){
			System.out.println(s.getImie() + " " + s.getNazwisko());
		}
	}
	
//	@Test // testuje modyfikacje encji
//	public void updateStudentTest() {
//
//		System.out.println("update");
//		StudentOperacje studentOperacje = new StudentOperacje();
//
//		Student ania = studentOperacje.findStudentById(4L);
//		
//		ania.setNazwisko("NazwiskoImme");
//		
//		studentOperacje.updateStudent(ania);
//		
//	}
}

