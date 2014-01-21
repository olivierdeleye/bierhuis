package be.vdab.services;

import be.vdab.entities.Soort;

public interface SoortService {

	void create(Soort soort);
	Soort read(long soortNr);
	void update(Soort soort);
	void delete(long soortNr);
	Iterable<Soort> findAll();
}
