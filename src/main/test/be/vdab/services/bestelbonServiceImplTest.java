package be.vdab.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import be.vdab.dao.BestelbonDAO;
import be.vdab.entities.Bestelbon;
import be.vdab.valueobjects.Adres;

public class bestelbonServiceImplTest {

	private BestelbonService bestelbonService;
	private Bestelbon bestelbon;
	
	@Before 
	 public void before() { 
	   bestelbon = new Bestelbon("TestNaam" ,new Adres("Straat", "HuisNr", 1000, "Gemeente")); 
	   BestelbonDAO bestelbonDAO = Mockito.mock(BestelbonDAO.class);
	   bestelbonService = new BestelbonServiceImpl(bestelbonDAO); 
	   Mockito.when(bestelbonService.read(1L)).thenReturn(bestelbon);
	   Mockito.when(bestelbonService.create(bestelbon)).thenReturn(bestelbon);
	 }
	
	@Test
	public void readBestelbonGeeftEenBestelbonEntityTerug(){
		bestelbonService.read(1L);
	}
	
	@Test 
	public void createGeeftEenBestelbonEntityTerug(){
		bestelbonService.create(bestelbon);
	}
}

