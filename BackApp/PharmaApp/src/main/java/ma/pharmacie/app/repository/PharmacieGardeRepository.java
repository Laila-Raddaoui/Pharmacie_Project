package ma.pharmacie.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.pharmacie.app.entities.PharmacieGarde;

public interface PharmacieGardeRepository extends JpaRepository<PharmacieGarde, Integer> {

}
