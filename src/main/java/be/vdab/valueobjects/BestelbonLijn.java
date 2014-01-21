package be.vdab.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.vdab.entities.Bier;

@Embeddable
public class BestelbonLijn implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne // mapping met Entity bier
	@JoinColumn(name = "bierNr")
	private Bier bier; 
	private Integer aantal;

	@Transient
	@NumberFormat(style = Style.NUMBER)
	private BigDecimal prijs;
	
	public BestelbonLijn() {
		
	}
	
	public BestelbonLijn(Bier bier, Integer aantal) {
		setBier(bier);
		setAantal(aantal);
		setPrijs();
	}

	public Integer getAantal() {
		return aantal;
	}

	public void setAantal(Integer aantal) {
		this.aantal = aantal;
	}
	
	
	public Bier getBier() {
		return bier;
	}

	public void setBier(Bier bier) {
		this.bier = bier;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}
	
	public void setPrijs(){
		prijs = bier.getPrijs().multiply(new BigDecimal(aantal));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((bier == null) ? 0 : bier.hashCode());
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
		BestelbonLijn other = (BestelbonLijn) obj;
		if (bier == null) {
			if (other.bier != null) {
				return false;
			}
		} else if (!bier.equals(other.bier)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return bier.getNaam() + ":" + aantal;
	}
	
	
	
}
