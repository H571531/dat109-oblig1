package no.hvl.dat109.spill;

import java.util.Random;

import no.hvl.dat109.utils.Dyr;
/**
 * Terning objektet
 * 
 * @author Gruppe
 */
public class Terning {
	
	private Random random;
	private Dyr verdi;
	
	public Terning() {
		random = new Random();
	}
	
	/**
	 * Velger en tilfeldig verdi fra dyr.
	 */
	public void kast() {
		verdi = Dyr.values()[random.nextInt(6)];
	}
	
	public Dyr getVerdi() {
		return verdi;
	}

	public void setVerdi(Dyr verdi) {
		this.verdi = verdi;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Terning other = (Terning) obj;
		if (verdi != other.verdi)
			return false;
		return true;
	}
	
	
	
	

}
