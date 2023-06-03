package ma.pharmacie.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.pharmacie.app.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	public Role findByNom(String nom);
}
