package no.hvl.dat109.Enteties;

import java.util.List;

public class Terning {
	
	private String resultat;
	
	
	public Terning() {
		resultat=finnVerdi();
	}
	
	private String finnVerdi() { //TODO!
		String dyr= "";
		
		
		return dyr;
	}
	
	public Terning[] kast(int i) {
		Terning[] resultat=new Terning[i];
		for(int t=0;t<i;t++) {
			resultat[t]=new Terning();
		}
		return resultat;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

}
