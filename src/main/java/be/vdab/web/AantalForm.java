package be.vdab.web;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

class AantalForm {

	private long bierNr;
   	
	@NumberFormat(style = Style.NUMBER)
	@Min(2)
	@NotNull
	private Integer aantal;
	
	
	public AantalForm() {
	
	}
	
	public AantalForm(Integer aantal){
		
		this.aantal = aantal;
	}
	
    public long getBierNr(){
		
		return bierNr;
	}
	
    public void setBierNr(long bierNr){
	   this.bierNr = bierNr;
	   
    }

	public Integer getAantal() {
		return aantal;
	}

	
	public void setAantal(Integer aantal) {
		this.aantal = aantal;
	}
	
	@Override 
	public String toString(){
		return String.format("%s-%s", aantal,bierNr);
	}
}
