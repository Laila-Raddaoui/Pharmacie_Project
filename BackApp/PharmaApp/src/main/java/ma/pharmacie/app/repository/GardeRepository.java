package ma.pharmacie.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.pharmacie.app.entities.Garde;

public interface GardeRepository extends JpaRepository<Garde, Integer> {
	public Garde findById(int id);
}
