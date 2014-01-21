package be.vdab.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.BierDAO;
import be.vdab.entities.Bier;

@Service
@Transactional(readOnly = true) 
public class BierServiceImpl implements BierService{

	 private final BierDAO bierDAO;
		
		@Autowired 
		public BierServiceImpl(BierDAO bierDAO) {
			this.bierDAO = bierDAO;
		}
		
		@Override
		@Transactional(readOnly = false)
		public void create(Bier bier) {
			bierDAO.save(bier);
			
		}

		@Override
		public Bier read(long bierNr) {
			return bierDAO.findOne(bierNr);
		}

		@Transactional(readOnly = false)
		@Override
		public void update(Bier bier) {
			bierDAO.save(bier);
			
		}
		
		@Override
		public Iterable<Bier> findBierenMetNummers(Set<Long> bierNrs) {
			
			return bierDAO.findByBierNrIn(bierNrs);
		}
		

		@Override
		public void delete(long bierNr) {
		   bierDAO.delete(bierNr);
			
		}

		@Override
		public Iterable<Bier> findAll() {
			return bierDAO.findAll();
		}
		
		@Override
		public long count() {
			return bierDAO.count();
		}

		

		
}
