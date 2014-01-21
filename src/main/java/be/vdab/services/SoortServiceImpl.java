package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.SoortDAO;
import be.vdab.entities.Soort;

@Service
@Transactional(readOnly = true) 
public class SoortServiceImpl implements SoortService{

	 private final SoortDAO soortDAO;
		
		@Autowired 
		public SoortServiceImpl(SoortDAO soortDAO){
			this.soortDAO = soortDAO;
		}
		
		@Override
		@Transactional(readOnly = false)
		public void create(Soort soort) {
			soortDAO.save(soort);
			
		}

		@Override
		public Soort read(long soortNr) {
			return soortDAO.findOne(soortNr);
		}

		@Transactional(readOnly = false)
		@Override
		public void update(Soort soort) {
			soortDAO.save(soort);
			
		}

		@Override
		public void delete(long soortNr) {
		  soortDAO.delete(soortNr);
			
		}

		@Override
		public Iterable<Soort> findAll() {
			return soortDAO.findAll();
		}
}
