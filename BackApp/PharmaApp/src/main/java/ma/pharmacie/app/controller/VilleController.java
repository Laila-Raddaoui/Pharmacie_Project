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
import ma.pharmacie.app.entities.Ville;
import ma.pharmacie.app.service.VilleServiceImpl;

@Tag(name = "Villes")
@RestController
@RequestMapping(value = "api/villes")
public class VilleController {
	@Autowired
	private VilleServiceImpl villeServiceImpl;

	@PostMapping(value = "/save")
	public Ville save(@RequestBody Ville object) {
		return villeServiceImpl.save(object);
	}

	@PutMapping(value = "/update")
	public Ville update(@RequestBody Ville object) {
		return villeServiceImpl.update(object);
	}

	@DeleteMapping(value = "/delete")
	public void delete(@RequestBody Ville object) {
		villeServiceImpl.delete(object);
	}

	@GetMapping(value = "/{id}")
	public Ville findById(@PathVariable String id) {
		return villeServiceImpl.findById(Integer.parseInt(id));
	}

	@GetMapping(value = "/")
	public List<Ville> findAll() {
		return villeServiceImpl.findAll();
	}

}
