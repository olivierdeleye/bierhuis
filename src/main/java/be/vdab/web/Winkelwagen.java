package be.vdab.web;

import java.util.Map;

public interface Winkelwagen {

	Map<Long,Integer> getBestelbonLijnen();
	void addBestelbonLijn(long bierNr, Integer aantal);
}
