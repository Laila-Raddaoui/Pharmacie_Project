package ma.pharmacie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pharmacie.app.entities.Pharmacie;
import ma.pharmacie.app.imetier.IMetier;
import ma.pharmacie.app.repository.PharmacieRepository;

@Service
public class PharmacieServiceImpl implements IMetier<Pharmacie> {
	@Autowired
	private PharmacieRepository pharmacieRepository;

	@Override
	public Pharmacie save(Pharmacie object) {
		return this.pharmacieRepository.save(object);
	}

	@Override
	public Pharmacie update(Pharmacie object) {
		return this.pharmacieRepository.save(object);
	}

	@Override
	public void delete(Pharmacie object) {
		this.pharmacieRepository.delete(object);
	}

	@Override
	public Pharmacie findById(int id) {
		return this.pharmacieRepository.findById(id);
	}

	@Override
	public List<Pharmacie> findAll() {
		return this.pharmacieRepository.findAll();
	}

}
