package ma.pharmacie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pharmacie.app.entities.Zone;
import ma.pharmacie.app.imetier.IMetier;
import ma.pharmacie.app.repository.ZoneRepository;

@Service
public class ZoneServiceImpl implements IMetier<Zone> {
	@Autowired
	private ZoneRepository zoneRepository;

	@Override
	public Zone save(Zone object) {
		return this.zoneRepository.save(object);
	}

	@Override
	public Zone update(Zone object) {
		return this.zoneRepository.save(object);
	}

	@Override
	public void delete(Zone object) {
		this.zoneRepository.delete(object);
	}

	@Override
	public Zone findById(int id) {
		return this.zoneRepository.findById(id);
	}

	@Override
	public List<Zone> findAll() {
		return this.zoneRepository.findAll();
	}

}
