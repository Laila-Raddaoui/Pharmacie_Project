package ma.pharmacie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pharmacie.app.entities.Ville;
import ma.pharmacie.app.imetier.IMetier;
import ma.pharmacie.app.repository.VilleRepository;

@Service
public class VilleServiceImpl implements IMetier<Ville> {
	@Autowired
	private VilleRepository villeRepository;

	@Override
	public Ville save(Ville object) {
		return this.villeRepository.save(object);
	}

	@Override
	public Ville update(Ville object) {
		return this.villeRepository.save(object);
	}

	@Override
	public void delete(Ville object) {
		this.villeRepository.delete(object);
	}

	@Override
	public Ville findById(int id) {
		return this.villeRepository.findById(id);
	}

	@Override
	public List<Ville> findAll() {
		return this.villeRepository.findAll();
	}

}
