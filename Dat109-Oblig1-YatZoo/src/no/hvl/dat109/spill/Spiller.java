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
	 * Konstruktør
	 * 
	 * @param navn Navn på spiller
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
	 * @param kopp TerningKoppen som skal kaste og holde rede på terningene
	 * @param skalBeholde Hvilke terninger som skal beholdes
	 * @param runde hvilken runde som spilles
	 * @return true hvis spiller er ferdig med runde: har valgt å beholde alle fem terninger, eller spiller har kastet tre ganger
	 */
	public boolean kastTerninger(TerningKopp kopp, boolean[] skalBeholde, int runde) {
		
		if(fornoyd(skalBeholde) || antallKast > 2) {
			
			resultater[runde] = kopp.beregnPoengForRunde(runde);
			ferdigMedRunde = true;
		} else {
			kopp.kast(skalBeholde);
			antallKast++;
			ferdigMedRunde = false;
		}
		
		return ferdigMedRunde;
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
	

	/**
	 * Metode for � beregne sum av kast.
	 * 
	 * @return Sum av alle poengsummer
	 */
	public int beregnSum() {
		int sum = 0;
		for(Integer i: resultater) {
			sum += ((i == null) ? 0 : i);
		}
		return sum;
	}
	
	/**
	 * Nullstiller spiller, brukes når en spiller starter å kaste i en ny runde
	 * @param kopp TerningKopp som skal nullstilles
	 */
	public void reset(TerningKopp kopp) {
		ferdigMedRunde = false;
		antallKast = 0;
		kopp.kast();
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


	
	

}
