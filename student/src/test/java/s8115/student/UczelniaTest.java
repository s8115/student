package s8115.student;

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
	


}


