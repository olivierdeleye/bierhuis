package be.vdab.services;

import be.vdab.entities.Bestelbon;

public interface BestelbonService {

	Bestelbon create(Bestelbon bestelbon);
	Bestelbon read(long bonNr);
	void update(Bestelbon bestelbon);
	void delete(long bonNr);
	Iterable<Bestelbon> findAll();
	
}
