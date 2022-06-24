package model;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;


/**
 * The persistent class for the kunde database table.
 * 
 */
@Entity
@NamedQuery(name="Kunde.findAll", query="SELECT k FROM Kunde k")
@RequestScoped
@Named("kunde")
public class Kunde implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nachname;

	private String vorname;

	public Kunde() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	@Override
	public Kunde clone() {
		Kunde tmp = new Kunde();
		tmp.setVorname(this.getVorname());
		tmp.setNachname(this.getNachname());
		return tmp;
	}
}