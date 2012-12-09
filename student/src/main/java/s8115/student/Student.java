package s8115.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// encja 
@Entity
public class Student {

	@Id // primary key
	@GeneratedValue // automatycznie generowanie wartosci
	
	private Long id;  // pole = kolumna 

	private String imie; // pole = kolumna

	private String nazwisko; // pole = kolumna

	private String pesel; // pole = kolumna

	private String telefon; // pole = kolumna

	public Long getId() {    // metoda udostepniajaca wartosc pola
		return id;
	}

	public void setId(Long id) { // metoda do ustawiania wartosc pola
		this.id = id;
	}

	public String getImie() {  // metoda do pobierania wartosc
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}
