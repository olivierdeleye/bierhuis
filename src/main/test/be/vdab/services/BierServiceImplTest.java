package be.vdab.services;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import be.vdab.dao.BierDAO;
import be.vdab.entities.Bier;
import be.vdab.entities.Brouwer;
import be.vdab.entities.Soort;

public class BierServiceImplTest {

	private BierService bierService;
	private Bier bier;
	private Iterable<Bier>bieren;
	
	@Before 
	 public void before() { 
	   bieren = Collections.emptyList();
	   bier = new Bier("testNaam", new Brouwer(), new Soort(), BigDecimal.ONE, BigDecimal.ONE);
	   BierDAO bierDAO = Mockito.mock(BierDAO.class);
	   bierService = new BierServiceImpl(bierDAO); 
	   Mockito.when(bierService.read(1L)).thenReturn(bier);
	   Mockito.when(bierService.findAll()).thenReturn(bieren);
	   Mockito.when(bierService.count()).thenReturn(1000L);
	   
	 }
	
	@Test
	public void findAllGeeftListMetBierenTerug(){
		Assert.assertSame(bieren, bierService.findAll());
	}
	
	@Test
	public void readGeeftEenBierEntityTerug(){
		Assert.assertSame(bier, bierService.read(1L));
	}
	
	@Test 
	public void countGeeftLongTerug(){
		Assert.assertEquals(1000L, bierService.count());
	}
	
	
}

