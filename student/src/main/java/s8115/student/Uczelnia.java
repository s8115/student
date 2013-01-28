package s8115.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Uczelnia {
	
	@Id // primary key
	@GeneratedValue // automatycznie generowanie wartosci
	private Long id;  // pole = kolumna 

	private String nazwaUczelni; // pole = kolumna

	private String miasto; // pole = kolumna

	private String ulica; // pole = kolumna

	private String telefon; // pole = kolumna

	public Long getId() {    // metoda udostepniajaca wartosc pola
		return id;
	}

	public void setId(Long id) { // metoda do ustawiania wartosc pola
		this.id = id;
	}
	
	public String getNazwaUczelni() {  // metoda do pobierania wartosc
		return nazwaUczelni;
	}
	
	public void setNazwaUczelni(String nazwaUczelni) {
		this.nazwaUczelni = nazwaUczelni;
	}
	
	public String getMiasto() {  // metoda do pobierania wartosc
		return miasto;
	}
	
	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}
	
	public String getUlica() {  // metoda do pobierania wartosc
		return ulica;
	}
	
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	
	public String getTelefon() {  // metoda do pobierania wartosc
		return telefon;
	}
	
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
}
