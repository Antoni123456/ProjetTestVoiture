package mg.ingenosya.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mg.ingenosya.demo.models.Voiture;

@RepositoryRestResource
public interface VoitureRepository extends JpaRepository<Voiture, Long>{
	
	public List<Voiture> findByIdVoiture(Long id);

}
