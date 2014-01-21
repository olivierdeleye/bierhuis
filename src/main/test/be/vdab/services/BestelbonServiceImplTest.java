package be.vdab.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import be.vdab.dao.BestelbonDAO;
import be.vdab.entities.Bestelbon;
import be.vdab.valueobjects.Adres;

public class BestelbonServiceImplTest {

	private BestelbonService bestelbonService;
	private BestelbonDAO bestelbonDAO;
	private Bestelbon bestelbon;
	
	@Before 
	 public void before() { 
	   bestelbon = new Bestelbon("TestNaam" ,new Adres("Straat", "HuisNr", 1000, "Gemeente")); 
	   bestelbonDAO = Mockito.mock(BestelbonDAO.class);
	   bestelbonService = new BestelbonServiceImpl(bestelbonDAO); 
	   Mockito.when(bestelbonService.read(1L)).thenReturn(bestelbon);
	   Mockito.when(bestelbonService.create(bestelbon)).thenReturn(bestelbon);
	 }
	
	@Test
	public void readBestelbonGeeftEenBestelbonEntityTerug(){
	    Assert.assertSame(bestelbon, bestelbonService.read(1L));
	}
	

	@Test 
	public void createGeeftEenBestelbonEntityTerug(){
	    Assert.assertSame(bestelbon, bestelbonService.create(bestelbon));
	}
	
}

