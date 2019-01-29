package no.hvl.dat109.spill;
/**
 * Spiller objektet
 * 
 * @author Gruppe
 */
public class Spiller {
	
	private String navn;
	public Integer[] resultater;
	int antallKast;
	boolean ferdigMedRunde;
	
	/**
	 * Konstruktør
	 * 
	 * @param navn på spiller
	 */
	public Spiller(String navn) {
		this.navn = navn;
		resultater = new Integer[12];
		antallKast = 0;
		ferdigMedRunde = false;
	}

	/**
	 * Metode som brukes per terning kast
	 * 
	 * @param koppen som skal bruke terningene
	 * @param skalBeholde Hvilke terninger som skal beholdes
	 * @param runde hvilken runde som spilles
	 * @return om brukeren er fornøyd.
	 */
	public boolean kastTerninger(TerningKopp kopp, boolean[] skalBeholde, int runde) {
		
		boolean fornoyd = fornoyd(skalBeholde);
		
		if(!fornoyd) {
			kopp.kast(skalBeholde);
			antallKast++;
		}
		
		//Hvis bruker har kastet tre ganger eller er fornÃ¸yd, gis ikke mulighet til Ã¥ velge terninger
		if(antallKast > 2 || fornoyd) {
			kopp.beregnPoengForRunde(runde);
			ferdigMedRunde = true;
			resultater[runde] = kopp.beregnPoengForRunde(runde);
			return true;
		} else {
			return fornoyd;
		}
		
	}
	
	/**
	 * GÃ¥ gjennom tabell med terninger - hvis det er valgt Ã¥ beholde alle returneres true
	 * @param skalBeholde oversikt over valgte terninger
	 * @return true hvis alle er valgt
	 */
	private boolean fornoyd(boolean[] skalBeholde) {
		for(Boolean b: skalBeholde) {
			if(!b)
				return false;
		}
		return true;
	}

	/**
	 * Kaster terningene
	 * 
	 * @param koppen som skal brukes
	 */
	public void kastTerninger(TerningKopp kopp) {
		kopp.kast(new boolean[] {false, false, false, false, false});
	}
	

/**
 * Metode for å beregne sum av kast.
 * 
 * @return
 */
	public int beregnSum() {
		int sum = 0;
		for(Integer i: resultater) {
			sum += ((i == null) ? 0 : i);
		}
		return sum;
	}
	
	public int getSum() {
		return beregnSum();
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Integer[] getResultater() {
		return resultater;
	}

	public void setResultater(Integer[] resultater) {
		this.resultater = resultater;
	}

	public boolean ferdigMedRunde() {
		return ferdigMedRunde;
	}

	public void setAntallKast(int i) {
		this.antallKast = i;
		
	}

	public void reset(TerningKopp kopp) {
		ferdigMedRunde = false;
		antallKast = 0;
		kopp.kast();
	}
	
	

}
