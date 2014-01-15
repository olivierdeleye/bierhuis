package be.vdab.entities;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name = "brouwers")
public class Brouwer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long brouwerNr;
	
	private String naam;
	
	
	@Embedded
	private Adres adres;

	private Integer omzet;
	
	@OneToMany(mappedBy = "brouwer")
	@OrderBy("naam")
	private Set<Bier> bieren;
	
	public Brouwer() {
		
	}
	
	public Brouwer(long brouwerNr, String naam, Adres adres, Integer omzet) {
		setBrouwerNr(brouwerNr);
		setNaam(naam);
		setAdres(adres);
		setOmzet(omzet);
	}
	
	public Brouwer(String naam, Adres adres, Integer omzet) {
		setNaam(naam);
		setAdres(adres);
		setOmzet(omzet);
		this.bieren = new LinkedHashSet<>();
	}
	

	public long getBrouwerNr() {
		return brouwerNr;
	}

	public void setBrouwerNr(long brouwerNr) {
		this.brouwerNr = brouwerNr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public Integer getOmzet() {
		return omzet;
	}

	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}

	public Set<Bier> getBieren() {
		return bieren;
	}

	public void setBieren(Set<Bier> bieren) {
		this.bieren = bieren;
	}
	
	

	@Override
	public String toString() {
		return naam + ", " + adres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((adres == null) ? 0 : adres.hashCode());
		result = (prime * result) + (int) (brouwerNr ^ (brouwerNr >>> 32));
		result = (prime * result) + ((naam == null) ? 0 : naam.hashCode());
		result = (prime * result) + ((omzet == null) ? 0 : omzet.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Brouwer other = (Brouwer) obj;
		if (adres == null) {
			if (other.adres != null) {
				return false;
			}
		} else if (!adres.equals(other.adres)) {
			return false;
		}
		if (brouwerNr != other.brouwerNr) {
			return false;
		}
		if (naam == null) {
			if (other.naam != null) {
				return false;
			}
		} else if (!naam.equals(other.naam)) {
			return false;
		}
		if (omzet == null) {
			if (other.omzet != null) {
				return false;
			}
		} else if (!omzet.equals(other.omzet)) {
			return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
}
