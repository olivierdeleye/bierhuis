package be.vdab.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import be.vdab.entities.Bier;
import be.vdab.services.BierService;

public class BierControllerTest {
	
	private BierService bierService;
	private BierController bierController;
	private Bier bier;

	@Before
	public void setUp(){
		bierService = Mockito.mock(BierService.class);
		bierController = new BierController(bierService);
		bierController = new BierController(bierService);
		
	}
	
	
	@Test 
	public void bierControllerVoegtRequestAttribuutBierToe(){
		Assert.assertSame(bier, bierController.createForm(1L).getModelMap().get("bier")); 
	}
	
	
	@Test
	public void createFormActiveertJuisteView() { 
	  Assert.assertEquals("brouwers/bierdetails", bierController.createForm(1L).getViewName());
	}
}
