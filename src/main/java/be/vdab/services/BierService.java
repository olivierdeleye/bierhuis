package be.vdab.services;

import be.vdab.entities.Bier;

public interface BierService {

	void create(Bier bier);
	Bier read(long bierNr);
	void update(Bier bier);
	void delete(long bierNr);
	Iterable<Bier> findAll();
	long count();

}
