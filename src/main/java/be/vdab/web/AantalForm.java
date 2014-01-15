package be.vdab.web;

import javax.validation.constraints.Min;

class AantalForm {

	@Min(0)
	private Integer aantal;
	
	public AantalForm() {
	}
	
	public AantalForm(Integer aantal) {
		
		this.aantal = aantal;
	}

	public Integer getAantal() {
		return aantal;
	}

	public void setAantal(Integer aantal) {
		this.aantal = aantal;
	}
	
	
}
