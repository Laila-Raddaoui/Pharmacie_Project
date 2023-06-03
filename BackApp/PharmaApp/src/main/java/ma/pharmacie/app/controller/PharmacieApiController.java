package ma.pharmacie.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import ma.pharmacie.app.entities.Pharmacie;
import ma.pharmacie.app.entities.Zone;
import ma.pharmacie.app.service.PharmacieApiServiceImpl;

@Tag(name = "Pharmacies APIs")
@RestController
@RequestMapping(value = "api/")
public class PharmacieApiController {
	@Autowired
	private PharmacieApiServiceImpl pharmacieApiServiceImpl;

	@GetMapping(value = "villes/{villeNom}/zones")
	public List<Zone> findAllZoneByVille(@PathVariable String villeNom) {
		return pharmacieApiServiceImpl.findAllZoneByVille(villeNom);
	}

	@GetMapping(value = "villes/{villeNom}/zones/{zoneNom}/pharmacies")
	public List<Pharmacie> findAllPharmacieByZone(@PathVariable String villeNom, @PathVariable String zoneNom) {
		return pharmacieApiServiceImpl.findAllPharmacieByZone(villeNom, zoneNom);
	}

	@GetMapping(value = "villes/{villeNom}/zones/{zoneNom}/pharmacies/garde")
	public List<Pharmacie> findAllPharmacieByGarde(@PathVariable String villeNom, @PathVariable String zoneNom,
			@RequestParam(name = "periode") String periode) {
		return pharmacieApiServiceImpl.findAllPharmacieByGarde(villeNom, zoneNom, periode);
	}

	@GetMapping(value = "pharmacies/{id}/itineraire")
	public Pharmacie findItineraireByDepart(@PathVariable String id, @RequestParam(name = "depart") String depart) {
		return null;
	}

}
