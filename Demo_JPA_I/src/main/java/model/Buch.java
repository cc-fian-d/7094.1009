package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the buch database table.
 * 
 */
@Entity
@NamedQuery(name="Buch.findAll", query="SELECT b FROM Buch b")
public class Buch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String isbn;

	private String autor;

	private String kurzbeschreibung;

	private float preis;

	private String titel;

	private String verlag;

	public Buch() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getKurzbeschreibung() {
		return this.kurzbeschreibung;
	}

	public void setKurzbeschreibung(String kurzbeschreibung) {
		this.kurzbeschreibung = kurzbeschreibung;
	}

	public float getPreis() {
		return this.preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

	public String getTitel() {
		return this.titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getVerlag() {
		return this.verlag;
	}

	public void setVerlag(String verlag) {
		this.verlag = verlag;
	}

}