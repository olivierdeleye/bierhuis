package be.vdab.web;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value ="session", proxyMode = ScopedProxyMode.INTERFACES)
public class WinkelwagenImpl implements Winkelwagen, Serializable{

	private static final long serialVersionUID=1L;
	private final Map<Long, Integer> winkelwagenItems;
	
	public WinkelwagenImpl(){
		winkelwagenItems = new LinkedHashMap<>();
	}
	
	@Override
	public void itemToevoegen(Long bierNr, Integer aantal) {
		if(winkelwagenItems.containsKey(bierNr)) {
			Integer nieuwAantal = winkelwagenItems.get(bierNr) + aantal;
			winkelwagenItems.remove(bierNr);
			winkelwagenItems.put(bierNr, nieuwAantal);
		}//indien dit bier reeds in winkelwagen wordt het aantal opgeteld en prijs aangepast
		else {
	      winkelwagenItems.put(bierNr, aantal);
		}
	}

    @Override
	public Map<Long, Integer> getWinkelwagenItems() {
		return winkelwagenItems;
	}

	@Override
	public void removeItems() {
		winkelwagenItems.clear();
		
	}
    
    
	
}
