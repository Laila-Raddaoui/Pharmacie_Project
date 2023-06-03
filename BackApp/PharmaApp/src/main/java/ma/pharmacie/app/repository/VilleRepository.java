package ma.pharmacie.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.pharmacie.app.entities.Ville;

public interface VilleRepository extends JpaRepository<Ville, Integer> {
	public Ville findById(int id);
}
