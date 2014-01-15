package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import be.vdab.valueobjects.BestelbonLijn;

@Entity
@Table(name = "bieren")
public class Bier implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long bierNr;
	
	private String naam;
	
	@ManyToOne(fetch=FetchType.LAZY) //bidirectionele relatie met Brouwer *..1
	@JoinColumn(name = "BrouwerNr")
	private Brouwer brouwer;
	
	@ManyToOne(fetch=FetchType.LAZY) //bidirectionele relatie met Soort *..1
	@JoinColumn(name = "SoortNr")
	private Soort soort;

	private BigDecimal alcohol;
	
	private BigDecimal prijs;
	
	@ElementCollection 
	@CollectionTable(name = "bestelbonlijnen", joinColumns = @JoinColumn(name = "BierNr"))
	private Set<BestelbonLijn> bestelbonLijnen;
	
	public Bier() {
		
	}

    public Bier(long bierNr, String naam, Brouwer brouwer, Soort soort, BigDecimal alcohol, BigDecimal prijs) {
		setBierNr(bierNr);
		setNaam(naam);
		setBrouwer(brouwer);
		setSoort(soort);
		setAlcohol(alcohol);
		setPrijs(prijs);
	}
    
    public Bier(String naam, Brouwer brouwer, Soort soortNr, BigDecimal alcohol, BigDecimal prijs) {
		setBierNr(bierNr);
		setNaam(naam);
		setBrouwer(brouwer);
		setSoort(soortNr);
		setAlcohol(alcohol);
		setPrijs(prijs);
		this.bestelbonLijnen = new LinkedHashSet<>();
		
	}
    
    
	
	public long getBierNr() {
		return bierNr;
	}

	public void setBierNr(long bierNr) {
		this.bierNr = bierNr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Brouwer getBrouwer() {
		return brouwer;
	}

	public void setBrouwer(Brouwer brouwer) {
		this.brouwer = brouwer;
	}

	public Soort getSoort() {
		return soort;
	}

	public void setSoort(Soort soort) {
		this.soort = soort;
	}
	
	

	public BigDecimal getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(BigDecimal alcohol) {
		this.alcohol = alcohol;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

	@Override
	public String toString() {
		return bierNr + " : " + naam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (int) (bierNr ^ (bierNr >>> 32));
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
		Bier other = (Bier) obj;
		if (bierNr != other.bierNr) {
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
