package be.vdab.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import be.vdab.services.BierService;

public class IndexControllerTest {

	private BierService bierService;
	private IndexController indexController;
	private long aantalBieren;
	
	
	@Before
	public void setUp(){
		bierService = Mockito.mock(BierService.class);
		indexController = new IndexController(bierService);
		Mockito.when(bierService.count()).thenReturn(1000L);
		aantalBieren = 1000L;
	}
	
	
	@Test 
	public void indexControllerVoegtRequestAttribuutAantalBierenToe(){
		Assert.assertEquals(aantalBieren, indexController.index().getModelMap().get("aantalBieren")); 
	}
	
	
	@Test
	public void indexActiveertJuisteView() { 
	  Assert.assertEquals("index", indexController.index().getViewName());
	}
	
}
