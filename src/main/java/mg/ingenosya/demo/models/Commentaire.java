package mg.ingenosya.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "commentaire")
public class Commentaire implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "id_seq_comment", sequenceName = "seq_comment", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq_comment")
	@Column(name = "id_comment")
	private Long idComment;
	
	@Column(name = "contenu")
	private String contenu;
	
	@Column(name = "username")
	private String nomUtilisateur;
	
	@Column(name = "date_comment")
	private Date dateComment;
	
	@ManyToOne
	@JoinColumn(name = "idVoiture")
	private Voiture voiture;
	
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Commentaire(String contenu, String nomUtilisateur, Date dateComment, Voiture voiture) {
		super();
		this.contenu = contenu;
		this.nomUtilisateur = nomUtilisateur;
		this.dateComment = dateComment;
		this.voiture = voiture;
	}

	public Long getIdComment() {
		return idComment;
	}

	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public Date getDateComment() {
		return dateComment;
	}

	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	
}
