package be.vdab.web;

import java.math.BigDecimal;
import java.util.Set;

import be.vdab.valueobjects.BestelbonLijn;

public interface Winkelwagen {

	Set<BestelbonLijn> getBestelbonLijnen();
	void addBestelbonLijn(BestelbonLijn bestelbonLijn);
	void removeRestelbonLijnen();
	BigDecimal getEindTotaal();
}
