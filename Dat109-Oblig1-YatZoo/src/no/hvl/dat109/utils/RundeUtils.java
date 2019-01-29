package no.hvl.dat109.utils;

import no.hvl.dat109.spill.TerningKopp;

public class RundeUtils {
	
	public static int beregnRunde(int runde, TerningKopp kopp) {
		int resultat = 0;
		
		switch(runde) {
		case 0:
			resultat = kopp.antallAvGittDyr(Dyr.LOVE);
			break;
		case 1:
			resultat = kopp.antallAvGittDyr(Dyr.SLANGE);
			break;
		case 2:
			resultat = kopp.antallAvGittDyr(Dyr.PANDA);
			break;
		case 3:
			resultat = kopp.antallAvGittDyr(Dyr.GRIS);
			break;
		case 4:
			resultat = kopp.antallAvGittDyr(Dyr.ELEFANT);
			break;
		case 5:
			resultat = kopp.antallAvGittDyr(Dyr.HVAL);
			break;
		case 6:
			resultat = kopp.gittAntallLike(3) ? 1 : 0;
			break;
		case 7:
			resultat = kopp.gittAntallLike(4) ? 1 : 0;
			break;
		case 8:
			resultat = kopp.toPar() ? 4 : 0;
			break;
		case 9:
			resultat = kopp.hus() ? 5 : 0;
			break;
		case 10:
			resultat = kopp.alleUlike() ? 5 : 0;
			break;
		case 11:
			resultat = kopp.alleLike() ? 10 : 0;
			break;
		}
		
		
		
		
		return resultat;
	}

}
