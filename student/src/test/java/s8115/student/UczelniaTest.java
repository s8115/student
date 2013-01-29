package s8115.student;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class UczelniaTest {
	
	@Test // testuje zapis
	public void saveTest() {
	
	UczelniaOperacje uczelniaOperacje = new UczelniaOperacje();

	Uczelnia s = new Uczelnia();
	s.setNazwaUczelni("PJWSTK");
	s.setMiasto("Gdañsk");
	s.setUlica("Brzegi");
	s.setTelefon("58243578");

	uczelniaOperacje.saveUczelnia(s);
	}
	
	@Test // testuje wyszukanie rekordu po Id
	public void findUczelniaTest() {

		UczelniaOperacje uczelniaOperacje = new UczelniaOperacje();

		Uczelnia s = new Uczelnia();
		s.setNazwaUczelni("PJWSTK");
		s.setMiasto("Gdañsk");
		s.setUlica("Brzegi");
		s.setTelefon("58243578");

		uczelniaOperacje.saveUczelnia(s);
		

		Uczelnia s1 = uczelniaOperacje.findUczelniaById(s.getId());

		Assert.assertNotNull(s1);
		Assert.assertEquals("PJWSTK", s1.getNazwaUczelni());
		
		
	}
	
	@Test  // testuje wyszukanie liste uczelni
	public void findListUczelniaTest() {

		UczelniaOperacje uczelniaOperacje = new UczelniaOperacje();

		List<Uczelnia>ListaUczelnia = uczelniaOperacje.findAllUczelnia();
		
		for(Uczelnia s : ListaUczelnia){
			System.out.println(s.getNazwaUczelni() + " " + s.getId());
		}
	}
	
	@Test  // testuje wyszukanie liste Uczelni
	public void findListUczelniaByNazwaUczelniTest() {

		UczelniaOperacje uczelniaOperacje = new UczelniaOperacje();

		List<Uczelnia>ListaUczelnia = uczelniaOperacje.findUczelniaByFilter("PJWSTK");
		System.out.println("@@@@@ SZUKANY OBIEKT:");
		for(Uczelnia s : ListaUczelnia){
			System.out.println(s.getNazwaUczelni() + " " + s.getId());
		}
	}
	
	/**
	 * testuje dodanie relacji uczelnia-student  i student-uczelnia
	 */
	@Test 
	public void findAddUczelniaToStudent(){
		
		UczelniaOperacje uczelniaOperacje = new UczelniaOperacje();
		
		Uczelnia s = new Uczelnia();
		s.setNazwaUczelni("PJWSTK1234");
		s.setMiasto("Gdañsk");
		s.setUlica("Brzegi");
		s.setTelefon("58243578");

		Student s1 = new Student();
		s1.setImie("Mi³osz");
		s1.setNazwisko("Talmon");
		s1.setPesel("78110606353");
		s1.setTelefon("783050098");
		
		Student s2 = new Student();
		s2.setImie("Krzyœ");
		s2.setNazwisko("Nowak");
		s2.setPesel("78111236353");
		s2.setTelefon("783059528");
		
		List<Student> listaStudentow = new ArrayList<Student>();
		listaStudentow.add(s1);
		listaStudentow.add(s2);
		
		s.setListaStudentow(listaStudentow);
		
		uczelniaOperacje.saveUczelnia(s);
		
		// -----------------------
		
		Uczelnia uczelniaZBazt = uczelniaOperacje.findUczelniaById(s.getId());
		
		for(Student stu : uczelniaZBazt.getListaStudentow()){
			System.out.println("#### imie: "+stu.getImie());
		}
		
		
	}
	


}


