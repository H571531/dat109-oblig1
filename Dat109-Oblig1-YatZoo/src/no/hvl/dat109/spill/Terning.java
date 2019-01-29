package no.hvl.dat109.spill;

import java.util.Random;

import no.hvl.dat109.utils.Dyr;

public class Terning {
	
	private Random random;
	private Dyr verdi;
	
	public Terning() {
		random = new Random();
	}
	
	public void kast() {
		verdi = Dyr.values()[random.nextInt(6)];
	}
	
	public Dyr getVerdi() {
		return verdi;
	}

}
