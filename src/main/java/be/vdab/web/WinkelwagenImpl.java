package be.vdab.web;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import be.vdab.valueobjects.BestelbonLijn;

@Component
@Scope(value ="session", proxyMode = ScopedProxyMode.INTERFACES)
public class WinkelwagenImpl implements Winkelwagen, Serializable{

	private static final long serialVersionUID=1L;
	private Set<BestelbonLijn> bestelbonLijnen;
	
	public WinkelwagenImpl(){
		bestelbonLijnen = new LinkedHashSet<>();
	}
	
	@Override
	public Set<BestelbonLijn> getBestelbonLijnen() {
		return bestelbonLijnen;
	}

	@Override
	public void addBestelbonLijn(BestelbonLijn bestelbonLijn) {
	  for(BestelbonLijn lijn : bestelbonLijnen){
	    if(lijn.getBier().equals(bestelbonLijn.getBier())){
			lijn.setAantal(lijn.getAantal() + bestelbonLijn.getAantal()); 
			lijn.setPrijs();
		 } //indien dit bier reeds in winkelwagen wordt het aantal opgeteld en prijs aangepast
	  }
	  bestelbonLijnen.add(bestelbonLijn);
	}
	
	@Override
	public void removeBestelbonLijnen() {
		bestelbonLijnen = null;
		
	}
	
    @Override
	public BigDecimal getEindTotaal() {
	  BigDecimal eindTotaal = BigDecimal.ZERO;
	  for(BestelbonLijn bestelbonLijn : bestelbonLijnen){
		  eindTotaal = eindTotaal.add(bestelbonLijn.getPrijs());
	  }
		return eindTotaal;
	}
}
