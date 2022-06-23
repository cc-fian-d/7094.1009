package model.learn;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the audioequipment database table.
 * 
 */
@Embeddable
public class AudioequipmentPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private String hersteller;

	private String typbezeichnung;

	public AudioequipmentPK() {
	}
	public String getHersteller() {
		return this.hersteller;
	}
	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}
	public String getTypbezeichnung() {
		return this.typbezeichnung;
	}
	public void setTypbezeichnung(String typbezeichnung) {
		this.typbezeichnung = typbezeichnung;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AudioequipmentPK)) {
			return false;
		}
		AudioequipmentPK castOther = (AudioequipmentPK)other;
		return 
			this.hersteller.equals(castOther.hersteller)
			&& this.typbezeichnung.equals(castOther.typbezeichnung);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.hersteller.hashCode();
		hash = hash * prime + this.typbezeichnung.hashCode();
		
		return hash;
	}
}