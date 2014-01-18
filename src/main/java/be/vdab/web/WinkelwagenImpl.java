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
@Scope(value="session", proxyMode= ScopedProxyMode.INTERFACES)
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
	  for(BestelbonLijn detail : bestelbonLijnen){
	    if(detail.getBier().equals(bestelbonLijn.getBier())){
			detail.setAantal(detail.getAantal() + bestelbonLijn.getAantal()); 
		 } //indien dit bier reeds in winkelwagen wordt het aantal opgeteld
	  }
	  bestelbonLijnen.add(bestelbonLijn);
	}
	
	@Override
	public void removeRestelbonLijnen() {
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
