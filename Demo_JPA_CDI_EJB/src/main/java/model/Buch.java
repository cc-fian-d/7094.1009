package model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name = Buch.QUERY_FINDALL, query = "SELECT b FROM Buch b" ),
	@NamedQuery(name = Buch.QUERY_FIND_BY_ID, query = "SELECT b FROM Buch b WHERE b.id =:id" ),
	@NamedQuery(name = Buch.QUERY_FIND_BY_TITLE, query = "SELECT b FROM Buch b WHERE b.titel LIKE :" + Buch.PARAMETER_FIND_BY_TITLE )})
@EntityListeners(BuchListener.class)
public class Buch {

	
	public static final String QUERY_FINDALL = "find_all_books";
	public static final String QUERY_FIND_BY_ID = "find_books_by_id";
	public static final String QUERY_FIND_BY_TITLE = "find_books_by_title";
	public static final String PARAMETER_FIND_BY_TITLE = "titel";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true, nullable = false)
	private String isbn;
	private String titel;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	private Autor autor;
	
	
	private String klappentext;
	private LocalDate erscheinungsDatum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public String getKlappentext() {
		return klappentext;
	}
	public void setKlappentext(String klappentext) {
		this.klappentext = klappentext;
	}
	public LocalDate getErscheinungsDatum() {
		return erscheinungsDatum;
	}
	public void setErscheinungsDatum(LocalDate erscheinungsDatum) {
		this.erscheinungsDatum = erscheinungsDatum;
	}
	

	public Buch() {
		this.setIsbn("");
		this.setTitel("");
		this.setKlappentext("");
		this.setErscheinungsDatum(LocalDate.now());
	}
	
	public Buch(int id, String isbn, String titel, Autor autor, String klappentext, LocalDate erscheinungsDatum) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titel = titel;
		this.autor = autor;
		this.klappentext = klappentext;
		this.erscheinungsDatum = erscheinungsDatum;
	}
	@Override
	public String toString() {
		return "Buch [id=" + id + ", isbn=" + isbn + ", titel=" + titel + ", autor=" + autor + ", klappentext="
				+ klappentext + ", erscheinungsDatum=" + erscheinungsDatum + "]";
	}

	
}
