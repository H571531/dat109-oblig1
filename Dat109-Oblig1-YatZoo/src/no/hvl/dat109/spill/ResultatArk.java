package no.hvl.dat109.spill;

/**
 * Klasse for Spill objektet
 * 
 * 
 * @author Gruppe 
 */
import java.util.HashMap;
import java.util.List;

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
	
	private final String[] rundeNavn = {"L&oslash;VER","SLANGER","PANDAER","GRISER","ELEFANTER","HVALER","TRE LIKE","FIRE LIKE","TO PAR","HUS","FEM ULIKE","FEM LIKE"};
	
	private Integer[][] resultater;
	private HashMap<Spiller, Integer[]> resultaterMap;
	
	/**
	 * Konstruktør for resultatarket
	 * 
	 * @param spillere som skal være med i spillet.
	 */
	public ResultatArk(List<Spiller> spillere) {
		resultater = new Integer[spillere.size()][12];
		resultaterMap = new HashMap<Spiller, Integer[]>();
		for(Spiller spiller: spillere) {
			resultaterMap.put(spiller, spiller.resultater);
			
		}
	}

	
	public Integer[][] getResultater() {
		return resultater;
	}

	
	public void setResultater(Integer[][] resultater) {
		this.resultater = resultater;
	}


	public HashMap<Spiller, Integer[]> getResultaterMap() {
		return resultaterMap;
	}


	public void setResultaterMap(HashMap<Spiller, Integer[]> resultaterMap) {
		this.resultaterMap = resultaterMap;
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
