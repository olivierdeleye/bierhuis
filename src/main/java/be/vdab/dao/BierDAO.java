package be.vdab.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.entities.Bier;


public interface BierDAO extends JpaRepository <Bier, Long>{

	 Iterable<Bier>findByBierNrIn(Set<Long>bierNrs);
}
