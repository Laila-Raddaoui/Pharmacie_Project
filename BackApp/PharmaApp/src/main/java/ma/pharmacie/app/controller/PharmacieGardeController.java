package ma.pharmacie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import ma.pharmacie.app.entities.PharmacieGarde;
import ma.pharmacie.app.service.PharmacieGardeService;

@Tag(name = "Pharmacie de garde")
@RestController
@RequestMapping(value = "api/pharmacieGarde")
public class PharmacieGardeController {
	
	@Autowired
	private PharmacieGardeService pharmacieGardeService;

	@PostMapping(value = "/save")
	public PharmacieGarde save(PharmacieGarde object) {
		return pharmacieGardeService.save(object);
	}

	@PutMapping(value = "/update")
	public PharmacieGarde update(PharmacieGarde object) {
		return pharmacieGardeService.update(object);
	}

	@DeleteMapping(value = "/delete")
	public void delete(PharmacieGarde object) {
		pharmacieGardeService.delete(object);
	}

	@GetMapping(value = "/")
	public List<PharmacieGarde> findAll() {
		return pharmacieGardeService.findAll();
	}
	
	

}
