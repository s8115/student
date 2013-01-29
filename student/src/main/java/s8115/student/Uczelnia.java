package s8115.student;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Uczelnia {
	
	@Id // primary key
	@GeneratedValue // automatycznie generowanie wartosci
	private Long id;  // pole = kolumna 

	private String nazwaUczelni; // pole = kolumna

	private String miasto; // pole = kolumna

	private String ulica; // pole = kolumna

	private String telefon; // pole = kolumna
	
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)	// relacja student-uczelnia
	private List<Student> listaStudentow;	// lista studentów, pole do encji student
	
	
	public List<Student> getListaStudentow() {
		return listaStudentow;
	}

	public void setListaStudentow(List<Student> listaStudentow) {
		this.listaStudentow = listaStudentow;
	}

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
