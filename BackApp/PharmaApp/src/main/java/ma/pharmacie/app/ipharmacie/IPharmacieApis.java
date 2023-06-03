package ma.pharmacie.app.ipharmacie;

import java.util.List;

import ma.pharmacie.app.entities.Pharmacie;
import ma.pharmacie.app.entities.Zone;

public interface IPharmacieApis {

	public List<Zone> findAllZoneByVille(String villeNom);

	public List<Pharmacie> findAllPharmacieByZone(String villeNom, String zoneNom);

	public List<Pharmacie> findAllPharmacieByGarde(String villeNom, String zoneNom, String periode);

	public Pharmacie findItineraireByDepart(String id, String depart);

}
