package be.vdab.web;

import java.util.Map;

public interface Winkelwagen {

	Map<Long, Integer> getWinkelwagenItems();
	void itemToevoegen(Long bierNr, Integer aantal);
	void removeItems();

}
