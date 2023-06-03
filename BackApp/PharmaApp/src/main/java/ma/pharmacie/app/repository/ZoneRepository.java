package ma.pharmacie.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.pharmacie.app.entities.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {
	public Zone findById(int id);
}
