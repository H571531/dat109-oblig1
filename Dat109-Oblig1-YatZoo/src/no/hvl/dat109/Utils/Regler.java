package no.hvl.dat109.Utils;

import java.util.List;

import no.hvl.dat109.Enteties.Terning;

public class Regler {
	public static int sjekkPoeng(int runde,List<Terning> terninger) {
		long resultat;
		
		switch(runde) {
		case 0:
			resultat=terninger.stream().filter(t->t.getResultat().equals("love")).count();
			break;
		case 1:
			resultat=terninger.stream().filter(t->t.getResultat().equals("slange")).count();
			break;
		case 2:
			resultat = terninger.stream().filter(t->t.getResultat().equals("panda")).count();
			break;
		case 3:
			resultat = terninger.stream().filter(t->t.getResultat().equals("gris")).count();
			break;
		case 4:
			resultat = terninger.stream().filter(t->t.getResultat().equals("elefant")).count();
			break;
		case 5:
			resultat = terninger.stream().filter(t->t.getResultat().equals("hval")).count();
			break;
		case 6:
			resultat = kopp.gittAntallLike(3) ? 1 : 0;
			break;
		case 7:
			resultat = kopp.gittAntallLike(4) ? 1 : 0;
			break;
		case 8:
			resultat = ;
			break;
		case 9:
			resultat = ;
			break;
		case 10:
			resultat = ;
			break;
		case 11:
			resultat = ;
			break;
		}
		
		
		
		
		return resultat;
	}
}
