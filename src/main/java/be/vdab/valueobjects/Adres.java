package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Adres implements Serializable{

	private String adres;
	private int postCode;
	private String gemeente;
	
	
	
	
	
	
	public String getAdres() {
		return adres;
	}
	public int getPostCode() {
		return postCode;
	}
	public String getGemeente() {
		return gemeente;
	}
	
}
