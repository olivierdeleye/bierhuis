package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.validation.constraints.Min;

@Embeddable
public class BestelbonLijn implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Min(0)
	private Integer aantal;
	
	public BestelbonLijn() {
		
	}
	
	public BestelbonLijn(Integer aantal) {
		
	}

	public Integer getAantal() {
		return aantal;
	}

	public void setAantal(Integer aantal) {
		this.aantal = aantal;
	}


	


	
	
	
	
	

}
