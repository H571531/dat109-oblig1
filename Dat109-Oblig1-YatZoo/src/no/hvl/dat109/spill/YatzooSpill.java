package no.hvl.dat109.spill;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class YatzooSpill {
	
	private Spiller[] spillere;
	private List<Spiller> spillereListe;
	private Spiller aktivSpiller;
	
	private int aktivSpillerInt;
	
	
	int runde;
	TerningKopp kopp;
	ResultatArk ark;
	
	public YatzooSpill(List<Spiller> spillere) {
		this.spillere= spillere.toArray(new Spiller[spillere.size()]);
		this.spillereListe = spillere;
		
		aktivSpillerInt = 0;
		
		runde = 0;
		kopp = new TerningKopp(5);
		ark = new ResultatArk(spillere);
		
	}
	
	
	//Byttet med spillRunde
//	public void spill() {
//		runde=0;
//		while(runde < 12) {
//			for(Spiller spiller: spillere) {
//				spiller.spillRunde(kopp, runde);
//				
//			}
//			runde++;
//		}
//	}
	
	
	
	public void startSpill() {
		runde = 0;
		aktivSpiller = spillere[0];
		kopp.reset();
		//aktivSpiller.kastTerninger(kopp, new boolean[] {false,  false, false, false, false}, 0);
		
		
	}
	
	public Spiller nesteSpiller() {
		
		if(aktivSpillerInt == spillere.length-1) {
			runde++;
		}
		aktivSpillerInt = (aktivSpillerInt + 1) % spillere.length;
		spillere[aktivSpillerInt].setAntallKast(0);
		
		
		
		aktivSpiller = spillere[aktivSpillerInt];
		aktivSpiller.reset();
		kopp.kast();
		
		return spillere[aktivSpillerInt];
	}


	public void spillRunde() {
		
		//aktivSpiller.kast();
		
		
//		if(aktivSpiller.ferdigMedRunde()) {
//			aktivSpiller = nesteSpiller();
//			kopp.reset();
//		}
		
		
	}
	
	public boolean utforNesteKast(boolean[] valgteTerninger) {
		return aktivSpiller.kastTerninger(kopp, valgteTerninger, runde);
		
		
	}
	
//	public void spillerSpillEnRunde(int nesteSpiller) {
//		spillere[nesteSpiller].spillRunde(kopp, runde);
//	}
	
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