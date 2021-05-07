package mg.ingenosya.demo.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "voiture")
public class Voiture implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "id_seq_voiture", sequenceName = "seq_voiture", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq_voiture")
	@Column(name = "id_voiture")
	private Long idVoiture;
	
	@Column(name = "marque")
	private String marque;
	
	@Column(name = "num")
	private String numero;
	
	@Column(name = "couleur")
	private String couleur;
	
	@Column(name = "type")
	private String type;
	
	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Voiture(String marque, String numero, String couleur, String type, Collection<Commentaire> comments) {
		super();
		this.marque = marque;
		this.numero = numero;
		this.couleur = couleur;
		this.type = type;
	}

	public Long getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
