package model.learn;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the audioequipment database table.
 * 
 */
@Entity
@NamedQuery(name="Audioequipment.findAll", query="SELECT a FROM Audioequipment a")
public class Audioequipment implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AudioequipmentPK id;

	private float preis;

	//bi-directional many-to-one association to Schulungsraum
	@OneToMany(mappedBy="audioequipment", cascade={CascadeType.ALL})
	private List<Schulungsraum> schulungsraeume;

	public Audioequipment() {
	}

	public AudioequipmentPK getId() {
		return this.id;
	}

	public void setId(AudioequipmentPK id) {
		this.id = id;
	}

	public float getPreis() {
		return this.preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

	public List<Schulungsraum> getSchulungsraeume() {
		return this.schulungsraeume;
	}

	public void setSchulungsraeume(List<Schulungsraum> schulungsraeume) {
		this.schulungsraeume = schulungsraeume;
	}

	public Schulungsraum addSchulungsraeume(Schulungsraum schulungsraeume) {
		getSchulungsraeume().add(schulungsraeume);
		schulungsraeume.setAudioequipment(this);

		return schulungsraeume;
	}

	public Schulungsraum removeSchulungsraeume(Schulungsraum schulungsraeume) {
		getSchulungsraeume().remove(schulungsraeume);
		schulungsraeume.setAudioequipment(null);

		return schulungsraeume;
	}

}