package no.hvl.dat109.spill;


import no.hvl.dat109.utils.PoengUtils;

public class TerningKopp {
	
	private Terning[] terninger;
	public static final boolean[] BEHOLD_INGEN_TERNINGER = {false, false, false, false, false};
	
	/**
	 * Constructor
	 * Oppretter en ny TerningKopp, initialiserer alle terninger
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
	 * Kaster terninger som ikke skal beholdes
	 * 
	 * @param skalBeholde hvilke terninger som ikke skal kastes
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
	 * @param runde Hvilken runde som spilles
	 * @return poengsummen
	 */
	public int beregnPoengForRunde(int runde) {
		return PoengUtils.beregnRunde(runde, this);
	}
	
	
	
	
	
	/**
	 * Kaster alle terningene, beholder ingen
	 */
	public void kast() {
		kast(BEHOLD_INGEN_TERNINGER);
	}
	
	
	public void setTerninger(Terning[] terninger) {
		this.terninger = terninger;
	}
	
	public int getAntallTerninger() {
		return terninger.length;
	}
	
	public Terning[] getTerninger() {
		return terninger;
	}
	
	

	
	
	

}
