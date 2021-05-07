package mg.ingenosya.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mg.ingenosya.demo.models.Commentaire;

@RepositoryRestResource
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
	
	@Query("SELECT c FROM Commentaire c WHERE c.voiture.idVoiture = ?1")
	public List<Commentaire> getCommentByVoiture(Long idVoiture);

}
