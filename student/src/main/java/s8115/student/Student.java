package s8115.student;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

// encja 
@Entity
public class Student {

	@Id
	// primary key
	@GeneratedValue
	// automatycznie generowanie wartosci
	private Long id; // pole = kolumna

	private String imie; // pole = kolumna

	private String nazwisko; // pole = kolumna

	private String pesel; // pole = kolumna

	private String telefon; // pole = kolumna

	@ManyToMany(mappedBy = "listaStudentow", fetch = FetchType.EAGER)
	// relacja student-uczelnia , mappedby-odwo³anie do relacji po drugiej
	// stronie
	private List<Uczelnia> listaUczelni; // lista studentów, pole do encji
											// student

	public List<Uczelnia> getListaUczelni() {
		return listaUczelni;
	}

	public void setListaUczelni(List<Uczelnia> listaUczelni) {
		this.listaUczelni = listaUczelni;
	}

	public Long getId() { // metoda udostepniajaca wartosc pola
		return id;
	}

	public void setId(Long id) { // metoda do ustawiania wartosc pola
		this.id = id;
	}

	public String getImie() { // metoda do pobierania wartosc
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
