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
import ma.pharmacie.app.entities.Garde;
import ma.pharmacie.app.service.GardeServiceImpl;

@Tag(name = "Gardes")
@RestController
@RequestMapping(value = "/api/gardes")
public class GardeController {
	@Autowired
	private GardeServiceImpl gardeServiceImpl;

	@PostMapping(value = "/save")
	public Garde save(@RequestBody Garde object) {
		return gardeServiceImpl.save(object);
	}

	@PutMapping(value = "/update")
	public Garde update(@RequestBody Garde object) {
		return gardeServiceImpl.update(object);
	}

	@DeleteMapping(value = "/delete")
	public void delete(@RequestBody Garde object) {
		gardeServiceImpl.delete(object);
	}

	@GetMapping(value = "/{id}")
	public Garde findById(@PathVariable String id) {
		return gardeServiceImpl.findById(Integer.parseInt(id));
	}

	@GetMapping(value = "/")
	public List<Garde> findAll() {
		return gardeServiceImpl.findAll();
	}
}
