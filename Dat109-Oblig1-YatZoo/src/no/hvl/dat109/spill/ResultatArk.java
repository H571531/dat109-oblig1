package no.hvl.dat109.spill;

/**
 * ResultatArk
 * Hjelpeklasse for å opprette poengskjema
 * Inneholder også final tabeller med Strings som vises i poengskjema og mellom kast.
 * 
 * 
 * @author Gruppe 
 */

public class ResultatArk {
	
	private final String[] rundeStrings = {
		"Runde 1: Flest mulig l&oslash;ver",
		"Runde 2: Flest mulig slanger",
		"Runde 3: Flest mulig pandaer",
		"Runde 4: Flest mulig griser",
		"Runde 5: Flest mulig elefanter",
		"Runde 6: Flest mulig hvaler",
		"Runde 7: Tre like",
		"Runde 8: Fire like",
		"Runde 9: To par",
		"Runde 10: Hus",
		"Runde 11: Fem ulike",
		"Runde 12: Fem like"
	};
	
	private final String[] bildeURLs = {
			"img/love.PNG",
			"img/slange.PNG", 
			"img/panda.PNG",
			"img/gris.PNG",
			"img/elefant.PNG",
			"img/hval.PNG",
			"img/treLike.PNG",
			"img/fireLike.PNG",
			"img/toPar.PNG",
			"img/hus.PNG",
			"img/femUlike.PNG",
			"img/alleLike.PNG"
	};
	
	private final String[] rundeNavn = {
			"L&oslash;VER",
			"SLANGER",
			"PANDAER",
			"GRISER",
			"ELEFANTER",
			"HVALER",
			"TRE LIKE",
			"FIRE LIKE",
			"TO PAR",
			"HUS",
			"FEM ULIKE",
			"FEM LIKE"};
	
	
	/**
	 * Konstrukt�r for resultatarket
	 * 
	 */
	public ResultatArk() {
		
	}

	


	public String[] getRundeStrings() {
		return rundeStrings;
	}


	public String[] getRundeNavn() {
		return rundeNavn;
	}


	public String[] getBildeURLs() {
		return bildeURLs;
	}
	
	
	
	
	

}
