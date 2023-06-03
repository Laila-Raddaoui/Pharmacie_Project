package ma.pharmacie.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.pharmacie.app.entities.Pharmacie;

public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer> {
	public Pharmacie findById(int id);
}
