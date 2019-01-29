package no.hvl.dat109.Enteties;

import java.util.Arrays;
import java.util.List;

import no.hvl.dat109.Utils.Regler;

public class Spiller {
	int[] poeng;
	private String navn;
	
	
	public Spiller(String navn) {
		poeng=new int[13];
		this.navn=navn; 
	}
	
	public boolean spillRunde(int rundenr, Terning terning) {
		poeng[rundenr]=Regler.sjekkPoeng(rundenr,kast(terning));
		
		return true;
	}

	private List<Terning> kast(Terning t) {
		Terning[] resultater=t.kast(5);
		List<Terning> resList=Arrays.asList(resultater);
		return resList;
	}

	public int getSum() {
		int sum=0;
		for (int i=0;i<poeng.length; i++) {
			sum=sum+poeng[i];
		}
		return sum;
	}

	

}
