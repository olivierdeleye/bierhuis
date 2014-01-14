package be.vdab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.dao.BestelbonDAO;
import be.vdab.entities.Bestelbon;

@Service
@Transactional(readOnly = true)
public class BestelbonServiceImpl implements BestelbonService{

   private final BestelbonDAO bestelbonDAO;
	
	@Autowired 
	public BestelbonServiceImpl(BestelbonDAO bestelbonDAO) {
		this.bestelbonDAO = bestelbonDAO;
	}
	
	@Override
	@Transactional(readOnly = false)
	public void create(Bestelbon bestelbon) {
		bestelbonDAO.save(bestelbon);
		
	}

	@Override
	public Bestelbon read(long bonNr) {
		return bestelbonDAO.findOne(bonNr);
	}

	@Transactional(readOnly = false)
	@Override
	public void update(Bestelbon bestelbon) {
		bestelbonDAO.save(bestelbon);
		
	}

	@Override
	public void delete(long bonNr) {
	   bestelbonDAO.delete(bonNr);
		
	}

	@Override
	public Iterable<Bestelbon> findAll() {
		return bestelbonDAO.findAll();
	}

}
