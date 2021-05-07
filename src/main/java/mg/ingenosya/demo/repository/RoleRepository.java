package mg.ingenosya.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import mg.ingenosya.demo.models.ERole;
import mg.ingenosya.demo.models.Role;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Integer> {
	
	public Optional<Role> findByName(ERole name);
}

