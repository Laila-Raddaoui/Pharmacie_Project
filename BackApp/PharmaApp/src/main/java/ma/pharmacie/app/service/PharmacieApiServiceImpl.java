package ma.pharmacie.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.pharmacie.app.entities.Pharmacie;
import ma.pharmacie.app.entities.Zone;
import ma.pharmacie.app.ipharmacie.IPharmacieApis;

@Service
public class PharmacieApiServiceImpl implements IPharmacieApis {

	@Autowired
	private PharmacieServiceImpl pharmacieServiceImpl;

	@Autowired
	private VilleServiceImpl villeServiceImpl;

	@Override
	public List<Zone> findAllZoneByVille(String villeNom) {
		return villeServiceImpl.findAll().stream().filter(p -> p.getNom().equals(villeNom)).findFirst().orElse(null)
				.getZones();
	}

	@Override
	public List<Pharmacie> findAllPharmacieByZone(String villeNom, String zoneNom) {
		return this.findAllZoneByVille(villeNom).stream().filter(zone -> zone.getNom().equals(zoneNom)).findFirst()
				.orElse(null).getPharmacies();
	}

	@Override
	public List<Pharmacie> findAllPharmacieByGarde(String villeNom, String zoneNom, String periode) {
		return this.findAllPharmacieByZone(villeNom, zoneNom).stream().map(p -> p.getPharamacieGarde()).findFirst()
				.orElse(null).stream().map(pg -> pg.getId().getGarde()).filter(g -> g.getType().equals(periode))
				.findFirst().orElse(null).getPharamacieGarde().stream().map(p -> p.getId().getPharmacie())
				.collect(Collectors.toList());
	}

	@Override
	public Pharmacie findItineraireByDepart(String id, String depart) {
		return pharmacieServiceImpl.findById(Integer.parseInt(id));
	}

}
