// Junit klasa ktora wykonuje testy

package s8115.student;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

	@Test // testuje zapis
	public void saveTest() {

		StudentOperacje studentOperacje = new StudentOperacje();

		Student s = new Student();
		s.setImie("Mi³osz");
		s.setNazwisko("Talmon");
		s.setPesel("78110606353");
		s.setTelefon("783050098");
		
		Uczelnia u1 = new Uczelnia();
		u1.setNazwaUczelni ("Uniwersytet Gdañsk");
		u1.setMiasto("Gdañsk");
		u1.setUlica("Bazynskiego");
		u1.setTelefon("103050098");
		
		Uczelnia u2 = new Uczelnia();
		u2.setNazwaUczelni("Politechnika Gdañsk");
		u2.setMiasto("Gdañsk");
		u2.setUlica("Do Studzienki");
		u2.setTelefon("783059000");
		
		List<Uczelnia> listaUczelni = new ArrayList<Uczelnia>();
		listaUczelni.add(u1);
		listaUczelni.add(u2);
		
		studentOperacje.saveStudentWithUczelnia(s, listaUczelni);
		
		
		
		//-------------------------
		
		Student studentZbazy = studentOperacje.findStudentById(s.getId());
		
		Assert.assertEquals(2, studentZbazy.getListaUczelni().size());  // sprawdzanie junitów
		
		for(Uczelnia ucz : studentZbazy.getListaUczelni()){
			System.out.println("**** nazwa: "+ucz.getNazwaUczelni());
		}
	}
	
	@Test // testuje wyszukanie rekordu po Id
	public void findStudentTest() {

		StudentOperacje studentOperacje = new StudentOperacje();

		Student s = new Student();
		s.setImie("Marek");
		s.setNazwisko("Nowak");
		s.setPesel("1234325678");
		s.setTelefon("674893095");

		studentOperacje.saveStudent(s);
		

		Student s1 = studentOperacje.findStudentById(s.getId());

		Assert.assertNotNull(s1);
		Assert.assertEquals("Marek", s1.getImie());
		
		
	}
	
	
	@Test  // testuje wyszukanie liste studentow
	public void findListStudentTest() {

		StudentOperacje studentOperacje = new StudentOperacje();

		List<Student>ListaStudent = studentOperacje.findAllStudent();
		
		for(Student s : ListaStudent){
			System.out.println(s.getImie() + " " + s.getNazwisko());
		}
	}
	
	@Test  // testuje wyszukanie liste studentow
	public void findListStudentByImieTest() {

		StudentOperacje studentOperacje = new StudentOperacje();

		List<Student>ListaStudent = studentOperacje.findStudentByFilter("Marek");
		System.out.println("@@@@@ SZUKANY OBIEKT:");
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

