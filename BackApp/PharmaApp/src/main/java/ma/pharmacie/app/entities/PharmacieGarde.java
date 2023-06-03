package ma.pharmacie.app.entities;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pharmacies_gardes")
@NoArgsConstructor
@Getter(value = AccessLevel.PUBLIC)
@Setter(value = AccessLevel.PUBLIC)
@EqualsAndHashCode
public class PharmacieGarde {
	@EmbeddedId
	private PharmacieGardePk id;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;

	@Embeddable
	@NoArgsConstructor
	@Getter(value = AccessLevel.PUBLIC)
	@Setter(value = AccessLevel.PUBLIC)
	public static class PharmacieGardePk implements Serializable {
		private static final long serialVersionUID = 1L;

		@ManyToOne
		@JsonIgnore
		private Pharmacie pharmacie;

		@ManyToOne
		@JsonIgnore
		private Garde garde;

		@Column(nullable = false)
		@Temporal(TemporalType.TIMESTAMP)
		private Date dateDebut;
	}
}
