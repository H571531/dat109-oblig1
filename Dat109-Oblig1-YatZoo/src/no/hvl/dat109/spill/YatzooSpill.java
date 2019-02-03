package no.hvl.dat109.spill;

import java.util.List;
/**
 * YatzooSpill 
 * 
 * 
 * @author Gruppe 
 */
public class YatzooSpill {
	
	private Spiller[] spillere;
	private Spiller aktivSpiller;
	
	private int aktivSpillerInt;
	
	
	int runde;
	TerningKopp kopp;
	ResultatArk ark;
	
	/**
	 * Constructor
	 * 
	 * @param spillere List med spillere som skal være med i spillet
	 */
	public YatzooSpill(List<Spiller> spillere) {
		this.spillere= spillere.toArray(new Spiller[spillere.size()]);
		
		aktivSpillerInt = 0;
		
		runde = 0;
		kopp = new TerningKopp(5);
		ark = new ResultatArk();
	}
	
	/**
	 * Starter spillet med første spiller
	 *
	 */
	public void startSpill() {
		runde = 0;
		aktivSpiller = spillere[0];
		utforNesteKast(TerningKopp.BEHOLD_INGEN_TERNINGER);
	}
	
	/**
	 * Bytter til neste spiller. 
	 * @return neste spiller
	 */
	public Spiller nesteSpiller() {
		
		//Hvis siste spiller er ferdig, begynn neste runde
		bestemOmNyRunde();
		
		aktivSpillerInt = (aktivSpillerInt + 1) % spillere.length;
		
		aktivSpiller = spillere[aktivSpillerInt];
		aktivSpiller.reset(kopp);
		
		return spillere[aktivSpillerInt];
	}

	/**
	 * Hvis siste spiller er ferdig, beveges spillet til neste runde
	 * 
	 */
	private void bestemOmNyRunde() {
		if(aktivSpillerInt == spillere.length-1) {
			runde++;
		}
	}
	
	/**
	 * Metode for å si ifra at aktivSpiller er ferdig med sin runde
	 * 
	 * @return om spiller er ferdig med runden. 
	 */
	public boolean aktivSpillerFerdigMedRunde() {
		return aktivSpiller.ferdigMedRunde();
	}


	/**
	 * Starter nytt kast
	 * 
	 * @param valgteTerninger Terninger som skal beholdes/kastes
	 * @return Hvis det velges ny spiller returneres at ingen terninger er valgt - hvis samme spiller skal gjøre neste kast returneres like valg som ble gitt
	 */
	public boolean[] utforNesteKast(boolean[] valgteTerninger) {
		
		boolean aktivSpillerFerdigMedRunde = aktivSpiller.kastTerninger(kopp, valgteTerninger, runde);
		
		if(aktivSpillerFerdigMedRunde) {
			nesteSpiller();
			valgteTerninger = TerningKopp.BEHOLD_INGEN_TERNINGER;
			aktivSpiller.kastTerninger(kopp, valgteTerninger, runde);
		} 
		
		return valgteTerninger;
		
	}
	

	/**
	 * Finner hvem som vinner
	 * 
	 * @return vinneren
	 */
	public Spiller finnVinner() {
		Spiller vinner = spillere[0];
		int hoyest = vinner.beregnSum();
		
		for(int i = 1; i < spillere.length; i++) {
			if(spillere[i].beregnSum() > hoyest) {
				vinner = spillere[i];
				hoyest = vinner.beregnSum();
			}
		}
		
		return vinner;
	}
	
	/**
	 * Sjekker om alle rundene er ferdig
	 * 
	 * @return om alle rundene er ferdig
	 */
	public boolean heltFerdig() {
		return runde == 12;
	}
	
	public Spiller getVinner() {
		return finnVinner();
	}
	
	public int getAntallSpillere() {
		return spillere.length;
	}


	public Spiller[] getSpillere() {
		return spillere;
	}


	public void setSpillere(Spiller[] spillere) {
		this.spillere = spillere;
	}


	public int getRunde() {
		return runde;
	}


	public void setRunde(int runde) {
		this.runde = runde;
	}


	public TerningKopp getKopp() {
		return kopp;
	}


	public void setKopp(TerningKopp kopp) {
		this.kopp = kopp;
	}


	public ResultatArk getArk() {
		return ark;
	}


	public void setArk(ResultatArk ark) {
		this.ark = ark;
	}


	public Spiller getAktivSpiller() {
		return aktivSpiller;
	}


	public void setAktivSpiller(Spiller aktivSpiller) {
		this.aktivSpiller = aktivSpiller;
	}


	


	
	
	
	
	

}
