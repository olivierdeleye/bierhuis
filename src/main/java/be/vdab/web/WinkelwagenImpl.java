package be.vdab.web;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value ="session", proxyMode = ScopedProxyMode.INTERFACES)
public class WinkelwagenImpl implements Winkelwagen,Serializable{

	private static final long serialVersionUID=1L;
	
	private final Map<Long, Integer> bestelbonLijnen;
	
	public WinkelwagenImpl(){
		bestelbonLijnen = new LinkedHashMap<>();
	}
	
	@Override
	public Map<Long, Integer> getBestelbonLijnen() {
		return bestelbonLijnen;
	}

	@Override
	public void addBestelbonLijn(long bierNr, Integer aantal) {
		bestelbonLijnen.put(bierNr, aantal);
	}

}
