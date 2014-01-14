package be.vdab.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="soorten")
public class Soort implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long soortNr;
	private String naam;

	@OneToMany(mappedBy = "soort")
	private Set<Bier> bieren;
	
	public Soort() {
		
	}

	public long getSoortNr() {
		return soortNr;
	}

	public void setSoortNr(long soortNr) {
		this.soortNr = soortNr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Set<Bier> getBieren() {
		return bieren;
	}

	public void setBieren(Set<Bier> bieren) {
		this.bieren = bieren;
	}

	@Override
	public String toString() {
		return soortNr + ", " + naam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Soort other = (Soort) obj;
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
