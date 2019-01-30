package no.hvl.dat109.spill;
/**
 * Spiller objektet
 * 
 * @author Gruppe
 */
public class Spiller {
	
	private String navn;
	public Integer[] resultater;
	private int antallKast;
	private boolean ferdigMedRunde;
	
	/**
	 * Konstrukt�r
	 * 
	 * @param navn p� spiller
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
	 * @return om brukeren er forn�yd.
	 */
	public void kastTerninger(TerningKopp kopp, boolean[] skalBeholde, int runde) {
		
		if(fornoyd(skalBeholde) || antallKast > 2) {
			ferdigMedRunde = true;
			resultater[runde] = kopp.beregnPoengForRunde(runde);
		} else {
			kopp.kast(skalBeholde);
			antallKast++;
		}
	}
	
	/**
	 * Gå gjennom tabell med terninger - hvis det er valgt å beholde alle returneres true
	 * @param skalBeholde oversikt over valgte terninger
	 * @return true hvis alle er valgt
	 */
	private boolean fornoyd(boolean[] skalBeholde) {
		for(Boolean b: skalBeholde) {
			if(!b) {
				return false;
			}
		}
		return true;
	}

//	/**
//	 * Kaster terningene
//	 * 
//	 * @param koppen som skal brukes
//	 */
//	public void kastTerninger(TerningKopp kopp) {
//		kopp.kast(new boolean[] {false, false, false, false, false});
//	}
	

/**
 * Metode for � beregne sum av kast.
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
	
	

	public int getAntallKast() {
		return antallKast;
	}

	public void reset(TerningKopp kopp) {
		ferdigMedRunde = false;
		antallKast = 0;
		kopp.kast();
	}
	
	

}
