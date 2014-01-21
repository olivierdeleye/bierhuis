package be.vdab.services;

import java.util.Set;

import be.vdab.entities.Bier;

public interface BierService {

	void create(Bier bier);
	Bier read(long bierNr);
	void update(Bier bier);
	void delete(long bierNr);
	Iterable<Bier> findAll();
	Iterable<Bier>findBierenMetNummers(Set<Long>bierNrs);
	long count();

}
