package ma.pharmacie.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.pharmacie.app.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>  {
	public Utilisateur findByEmail(String email);
}
