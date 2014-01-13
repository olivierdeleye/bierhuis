package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brouwers")
public class Brouwer implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long brouwerNr;
	private String naam;
	private 
}
