package no.hvl.dat109.spill;

public class Spiller {
	
	private String navn;
	public Integer[] resultater;
	int antallKast;
	boolean ferdigMedRunde;
	
	public Spiller(String navn) {
		this.navn = navn;
		resultater = new Integer[12];
		antallKast = 0;
		ferdigMedRunde = false;
	}

	
	public boolean kastTerninger(TerningKopp kopp, boolean[] skalBeholde, int runde) {
		
		boolean fornoyd = fornoyd(skalBeholde);
		
		if(!fornoyd) {
			kopp.kast(skalBeholde);
			antallKast++;
		}
		
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
	 * Gå gjennom tabell med terninger - hvis det er valgt å beholde alle returneres true
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

	public void kastTerninger(TerningKopp kopp) {
		kopp.kast(new boolean[] {false, false, false, false, false});
	}
	


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

	public void reset() {
		ferdigMedRunde = false;
		antallKast = 0;
		
		
		
	}
	
	

}
