package mg.ingenosya.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mg.ingenosya.demo.models.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
	
	public Optional<User> findByUsername(String username);
	
	public Boolean existsByUsername(String username);
	
	public Boolean existsByEmail(String email);
}

