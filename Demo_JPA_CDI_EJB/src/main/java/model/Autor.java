package model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nachname;
	private String vorname;
	
	@OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private List<Buch> buecher;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public List<Buch> getBuecher() {
		return buecher;
	}

	public void setBuecher(List<Buch> buecher) {
		this.buecher = buecher;
	}
	
	public Autor() {
		this.setBuecher(new ArrayList<Buch>());
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nachname=" + nachname + ", vorname=" + vorname + "]";
	}



}
