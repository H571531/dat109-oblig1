package no.hvl.dat109.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import no.hvl.dat109.spill.Terning;
import no.hvl.dat109.spill.TerningKopp;

public class PoengUtils {
	
	
	
	public static int beregnRunde(int runde, TerningKopp kopp) {
		int resultat = 0;
		
		switch(runde) {
		case 0:
			resultat = antallAvGittDyr(Dyr.LOVE, kopp);
			break;
		case 1:
			resultat = antallAvGittDyr(Dyr.SLANGE, kopp);
			break;
		case 2:
			resultat = antallAvGittDyr(Dyr.PANDA, kopp);
			break;
		case 3:
			resultat = antallAvGittDyr(Dyr.GRIS, kopp);
			break;
		case 4:
			resultat = antallAvGittDyr(Dyr.ELEFANT, kopp);
			break;
		case 5:
			resultat = antallAvGittDyr(Dyr.HVAL, kopp);
			break;
		case 6:
			resultat = gittAntallLike(3, kopp) ? 3 : 0;
			break;
		case 7:
			resultat = gittAntallLike(4, kopp) ? 4 : 0;
			break;
		case 8:
			resultat = toPar(kopp) ? 4 : 0;
			break;
		case 9:
			resultat = hus(kopp) ? 5 : 0;
			break;
		case 10:
			resultat = alleUlike(kopp) ? 5 : 0;
			break;
		case 11:
			resultat = alleLike(kopp) ? 10 : 0;
			break;
		}
		
		
		
		
		return resultat;
	}
	
	/**
	 * Finner hvor mange av et gitt dyr koppen inneholder
	 * @param dyr Dyr det skal ses etter
	 * @return Hvor mange av det gitte dyret som finnes i koppen
	 */
	public static int antallAvGittDyr(Dyr dyr, TerningKopp kopp) {
		int antall = 0;
		for(Terning terning: kopp.getTerninger()) {
			if(terning.getVerdi().equals(dyr)) {
				antall++;
			}
		}
		return antall;
	}
	
	/**
	 * Regel for 7. og 8. runde. Finner om koppen inneholder et gitt antall av hvilket som helst dyr
	 * 
	 * @param antall Antall det skal ses etter
	 * @return true hvis det finnes et gitt antall like av et hvilket som helst dyr
	 */
	public static boolean gittAntallLike(int antall, TerningKopp kopp) {
		boolean ok = false;
		
		int i = 0;
		while(!ok && i < 6) {
			if(antallAvGittDyr(Dyr.values()[i], kopp) >= antall) {
				ok = true;
			} else {
				i++;
			}
		}
		
		return ok;
		
	}
	/**
	 * Poeng regning for toPar runden
	 * @return true hvis det finnes to par av to ulike dyr
	 */
	public static boolean toPar(TerningKopp kopp) {
		boolean ok = false;
		int antallDyrMedTo = 0;
		
		Integer[] tab = tabellMedAntall(kopp);
		int i = 0;
		
		while(!ok && i < 6) {
			if(tab[i] >= 2) {
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
	 * Hjelpemetode for å finne hvor mange av en spesifikk verdi
	 * 
	 * 
	 * @return Tabell med antall av spesifikke dyr
	 */
	private static Integer[] tabellMedAntall(TerningKopp kopp) {
		Integer[] dyreTab = new Integer[6];
		
		for(int i = 0; i < 6; i++) {
			dyreTab[i] = antallAvGittDyr(Dyr.values()[i], kopp);
			
		}
		return dyreTab;
	}
	/**
	 * Hus regel
	 * 
	 * @return Om koppen har tre like av ett dyr, og to like av et annet
	 */
	public static boolean hus(TerningKopp kopp) {
		Integer[] tab = tabellMedAntall(kopp);
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
	public static boolean alleUlike(TerningKopp kopp) {
		
		//Set kan kun inneholde en av et gitt element, returnerer false hvis det prøves å legge til noe som allerede finnes
		Set<Dyr> set = new HashSet<Dyr>();
		for(Terning terning: kopp.getTerninger()) {
			if(!set.add(terning.getVerdi())) {
				return false;
			}
		}
		
		return true;
		
	}
	
	/**
	 * Metode for å sejkke om alle kastene var like
	 * 
	 * @return
	 */
	public static boolean alleLike(TerningKopp kopp) {
		
		Terning[] terninger = kopp.getTerninger();
		
		for(int i = 1; i < terninger.length; i++) {
			if(!terninger[i].equals(terninger[i-1])) {
				return false;
			}
		}
		
		return true;
	}

}
