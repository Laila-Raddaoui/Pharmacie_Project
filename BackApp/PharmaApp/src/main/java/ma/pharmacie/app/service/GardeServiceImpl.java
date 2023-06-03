package ma.pharmacie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pharmacie.app.entities.Garde;
import ma.pharmacie.app.imetier.IMetier;
import ma.pharmacie.app.repository.GardeRepository;

@Service
public class GardeServiceImpl implements IMetier<Garde> {
	@Autowired
	private GardeRepository gardeRepository;

	@Override
	public Garde save(Garde object) {
		return this.gardeRepository.save(object);
	}

	@Override
	public Garde update(Garde object) {
		return this.gardeRepository.save(object);
	}

	@Override
	public void delete(Garde object) {
		this.gardeRepository.delete(object);
	}

	@Override
	public Garde findById(int id) {
		return this.gardeRepository.findById(id);
	}

	@Override
	public List<Garde> findAll() {
		return this.gardeRepository.findAll();
	}

}
