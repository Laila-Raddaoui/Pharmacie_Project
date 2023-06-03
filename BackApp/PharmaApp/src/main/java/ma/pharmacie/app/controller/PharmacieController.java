package ma.pharmacie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import ma.pharmacie.app.entities.Pharmacie;
import ma.pharmacie.app.service.PharmacieServiceImpl;

@Tag(name = "Pharmacies")
@RestController
@RequestMapping(value = "/api/pharmacies")
public class PharmacieController {
	@Autowired
	private PharmacieServiceImpl pharmacieServiceImpl;

	@PostMapping(value = "/save")
	public Pharmacie save(@RequestBody Pharmacie object) {
		return pharmacieServiceImpl.save(object);
	}

	@PutMapping(value = "/update")
	public Pharmacie update(@RequestBody Pharmacie object) {
		return pharmacieServiceImpl.update(object);
	}

	@DeleteMapping(value = "/delete")
	public void delete(@RequestBody Pharmacie object) {
		pharmacieServiceImpl.delete(object);
	}

	@GetMapping(value = "/{id}")
	public Pharmacie findById(@PathVariable String id) {
		return pharmacieServiceImpl.findById(Integer.parseInt(id));
	}

	@GetMapping(value = "/")
	public List<Pharmacie> findAll() {
		return pharmacieServiceImpl.findAll();
	}

}
