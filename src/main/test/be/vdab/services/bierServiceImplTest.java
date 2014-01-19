package be.vdab.services;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import be.vdab.dao.BierDAO;
import be.vdab.entities.Bier;
import be.vdab.entities.Brouwer;
import be.vdab.entities.Soort;

public class bierServiceImplTest {

	private BierService bierService;
	private Brouwer brouwer;
	private Soort soort;
	private Bier bier;
	private Iterable<Bier>bieren;
	
	@Before 
	 public void before() { 
	   bieren = Collections.emptyList();
	   bier = new Bier("testNaam",brouwer,soort,BigDecimal.ONE,BigDecimal.ONE); 
	   BierDAO bierDAO = Mockito.mock(BierDAO.class);
	   bierService = new BierServiceImpl(bierDAO); 
	   Mockito.when(bierService.read(1L)).thenReturn(bier);
	   Mockito.when(bierService.findAll()).thenReturn(bieren);
	   Mockito.when(bierService.count()).thenReturn(1000L);
	   
	 }
	
	@Test
	public void findAllGeeftListMetBierenTerug(){
		bierService.findAll();
	}
	
	@Test
	public void readGeeftEenBierEntityTerug(){
		bierService.read(1L);
	}
	
	@Test 
	public void countGeeftLongTerug(){
		bierService.count();
	}
	
	
}

