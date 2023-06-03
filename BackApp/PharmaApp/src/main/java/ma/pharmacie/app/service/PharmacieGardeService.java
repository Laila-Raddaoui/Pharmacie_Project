package ma.pharmacie.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pharmacie.app.entities.PharmacieGarde;
import ma.pharmacie.app.imetier.IMetier;
import ma.pharmacie.app.repository.PharmacieGardeRepository;

@Service
public class PharmacieGardeService implements IMetier<PharmacieGarde> {

	@Autowired
	private PharmacieGardeRepository gardeRepository;
	
	@Override
	public PharmacieGarde save(PharmacieGarde object) {
		return gardeRepository.save(object);
	}

	@Override
	public PharmacieGarde update(PharmacieGarde object) {
		return gardeRepository.save(object);
	}

	@Override
	public void delete(PharmacieGarde object) {
		gardeRepository.delete(object);
	}

	@Override
	public PharmacieGarde findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PharmacieGarde> findAll() {
		return gardeRepository.findAll();
	}

}
