package no.hvl.dat109.spill;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import no.hvl.dat109.utils.Dyr;
import no.hvl.dat109.utils.RundeUtils;

public class TerningKopp {
	
	Terning[] terninger;
	public static final boolean[] BEHOLD_INGEN_TERNINGER = {false, false, false, false, false};
	
	/**
	 * Lager nye terninger
	 * 
	 * @param antallTerninger som skal oprettes. 
	 */
	public TerningKopp(int antallTerninger) {
		terninger = new Terning[antallTerninger];
		for(int i = 0; i < antallTerninger; i++) {
			terninger[i] = new Terning();
		}
		
	}
	/**
	 * hjelpemetode for � gj�re alle "skalBeholde" til false. 
	 */
	public void reset() {
		kast(BEHOLD_INGEN_TERNINGER);
	}
	
	/**
	 * Kaster terninger basert p� hvor mange 
	 * 
	 * @param Hvor mange av terningene som skal beholdes 
	 */
	public void kast(boolean[] skalBeholde) {
		
		
		for(int i = 0; i < terninger.length; i++) {
			if(!skalBeholde[i])
				terninger[i].kast();
		}
		
	}
	/**
	 * Sender en request til Rundeutils for � f� tilbake poengsum
	 * 
	 * @param hvilken runde som spilles
	 * @return poengsummen
	 */
	public int beregnPoengForRunde(int runde) {
		return RundeUtils.beregnRunde(runde, this);
	}
	
	
	
	public int getAntallTerninger() {
		return terninger.length;
	}
	
	public Terning[] getTerninger() {
		return terninger;
	}
	
	public int antallAvGittDyr(Dyr dyr) {
		int antall = 0;
		for(Terning terning: terninger) {
			if(terning.getVerdi().equals(dyr)) {
				antall++;
			}
		}
		return antall;
	}
	/**
	 * Regel for 1.-6. runde
	 * 
	 * @param antall
	 * @return poengsummen av like
	 */
	public boolean gittAntallLike(int antall) {
		boolean ok = false;
		
		int i = 0;
		while(!ok && i < 5) {
			if(antallAvGittDyr(Dyr.values()[i]) == antall) {
				ok = true;
			} else {
				i++;
			}
		}
		
		return ok;
		
	}
	/**
	 * Poeng regning for toPar runden
	 * @return poengsummen
	 */
	public boolean toPar() {
		boolean ok = false;
		int antallDyrMedTo = 0;
		
		Integer[] tab = tabellMedAntall();
		int i = 0;
		
		
		
		while(!ok && i < 6) {
			if(tab[i] == 2) {
				antallDyrMedTo++;
				if(antallDyrMedTo == 2) {
					ok = true;
				}
			}
			
			i++;
		}
		
		return ok;
		
	}
	/**
	 * Hjelpemetode for � finne hvor mange av en spesifikk verdi
	 * 
	 * 
	 * @return antall av spesifikke dyr
	 */
	public Integer[] tabellMedAntall() {
		Integer[] dyreTab = new Integer[6];
		
		for(int i = 0; i < 6; i++) {
			dyreTab[i] = antallAvGittDyr(Dyr.values()[i]);
			
		}
		return dyreTab;
	}
/**
 * Hus regel
 * 
 * @return poengsum
 */
	public boolean hus() {
		Integer[] tab = tabellMedAntall();
		List<Integer> liste = Arrays.asList(tab);
		
		if(liste.contains(2) && liste.contains(3)) {
			return true;
		} else {
			return false;
		}
	}
/**
 * Regel for alle ulike
 * 
 * @return om alle er ulike
 */
	public boolean alleUlike() {
		
		//Set kan kun inneholde en av et gitt element, returnerer false hvis det prøves å legge til noe som allerede finnes
		Set<Dyr> set = new HashSet<Dyr>();
		for(Terning terning: terninger) {
			if(!set.add(terning.getVerdi())) {
				return false;
			}
		}
		
		return true;
		
	}
/**
 * Metode for � sejkke om alle kastene var like
 * 
 * @return
 */
	public boolean alleLike() {
		boolean ok = true;
		
		for(int i = 1; i < terninger.length; i++) {
			if(!terninger[i].equals(terninger[i-1])) {
				ok = false;
			}
		}
		
		return ok;
	}
/**
 * Kaster alle terningene
 */
	public void kast() {
		kast(new boolean[] {false, false, false, false, false});
		
	}

	
	
	

}
