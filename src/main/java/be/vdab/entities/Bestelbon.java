package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import be.vdab.valueobjects.Adres;
import be.vdab.valueobjects.BestelbonLijn;

@Entity
@Table(name="bestelbonnen")
public class Bestelbon implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long bonNr;
	
	@NotNull
	@Size(min = 1, max = 50, message = "{Size.tekst}")
	private String naam;
	
	@Valid
	@Embedded
	private Adres adres;
	
	@ElementCollection 
	@CollectionTable(name = "bestelbonlijnen", joinColumns = @JoinColumn(name = "BonNr"))
	private Set<BestelbonLijn> bestelbonLijnen = new LinkedHashSet<>();
	
	public Bestelbon() {
		
	}
	
	public Bestelbon(long bonNr, String naam, Adres adres) {
		setBonNr(bonNr);
		setNaam(naam);
		setAdres(adres);
		
	}
	
	public Bestelbon(String naam, Adres adres) {
		setNaam(naam);
		setAdres(adres);
		
	}

	public long getBonNr() {
		return bonNr;
	}

	public void setBonNr(long bonNr) {
		this.bonNr = bonNr;
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
	
	public Set<BestelbonLijn> getBestelbonLijnen() {
		return bestelbonLijnen;
	}

	public void setBestelbonLijnen(Set<BestelbonLijn> bestelbonLijnen) {
		this.bestelbonLijnen = bestelbonLijnen;
	}
	

	public void addBestelbonLijn(BestelbonLijn bestelbonLijn) {
	   bestelbonLijnen.add(bestelbonLijn);
	}
	
    public void removeBestelbonLijnen() {
		bestelbonLijnen = null;
		
	}
	
	public BigDecimal getEindTotaal() {
	 BigDecimal eindTotaal = BigDecimal.ZERO;
		for(BestelbonLijn bestelbonLijn : bestelbonLijnen){
			eindTotaal = eindTotaal.add(bestelbonLijn.getPrijs());
		}
	 return eindTotaal;
	}

	@Override
	public String toString() {
		return bonNr + ", " + naam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((adres == null) ? 0 : adres.hashCode());
		result = (prime * result) + ((naam == null) ? 0 : naam.hashCode());
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
		Bestelbon other = (Bestelbon) obj;
		if (adres == null) {
			if (other.adres != null) {
				return false;
			}
		} else if (!adres.equals(other.adres)) {
			return false;
		}
		if (naam == null) {
			if (other.naam != null) {
				return false;
			}
		} else if (!naam.equals(other.naam)) {
			return false;
		}
		return true;
	}


	
	


}
