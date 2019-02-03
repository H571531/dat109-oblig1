package no.hvl.dat109.spill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class YatzooSpillTest {
	
	YatzooSpill spill;
	Spiller spiller1;
	Spiller spiller2;
	Spiller spiller3;
	
	final boolean[] beholdAlleTerninger = {true, true, true, true, true};
	final boolean[] beholdIngenTerninger = {false, false, false, false, false};
	
	@Before
	public void setup() {
		spiller1 = new Spiller("spiller1");
		spiller2 = new Spiller("spiller2");
		spiller3 = new Spiller("spiller3");
		List<Spiller> spillere = Arrays.asList(new Spiller[] {spiller1, spiller2, spiller3});
		spill = new YatzooSpill(spillere);
		
	}

	@Test
	public void startSpillUtforerEtKoppKast() {
		
		
		for(Terning terning: spill.getKopp().getTerninger()) {
			assertNull(terning.getVerdi());
		}
		
		spill.startSpill();
		for(Terning terning: spill.getKopp().getTerninger()) {
			assertNotNull(terning.getVerdi());
		}
		
	}
	
	@Test
	public void aktuellSpillerGirRettSpiller() {
		
		assertNull(spill.getAktivSpiller());
		
		spill.startSpill();
		
		assertEquals(spiller1, spill.getAktivSpiller());
		assertNotEquals(spiller2, spill.getAktivSpiller());
		
		spill.nesteSpiller();
		assertEquals(spiller2, spill.getAktivSpiller());
		
		spill.nesteSpiller();
		assertEquals(spiller3, spill.getAktivSpiller());
		
	}
	
	@Test
	public void nesteSpillerBytterTilRettSpiller() {
		assertNull(spill.getAktivSpiller());
		
		spill.startSpill();
		
		assertEquals(spiller1, spill.getSpillere()[0]);
		
		spill.nesteSpiller();
		assertEquals(spiller2, spill.getSpillere()[1]);
		
		spill.nesteSpiller();
		assertEquals(spiller3, spill.getSpillere()[2]);
	}
	
	@Test
	public void nyRundeEtterAlleSpillereErFerdig() {
		assertEquals(0, spill.getRunde());
		
		spill.startSpill();
		assertEquals(0, spill.getRunde());
		
		spill.nesteSpiller();
		assertEquals(0, spill.getRunde());
		
		spill.nesteSpiller();
		spill.nesteSpiller();
		assertEquals(1, spill.getRunde());
		
		spill.nesteSpiller();
		spill.nesteSpiller();
		spill.nesteSpiller();
		
		assertEquals(2, spill.getRunde());
	}
	
	@Test
	public void spillFerdigEtter12Runder() {
		spill.startSpill();
		
		assertFalse(spill.heltFerdig());
		
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 3; j++) {
				spill.nesteSpiller();
			}
		}
		
		assertTrue(spill.heltFerdig());
	}
	
	@Test
	public void utforNesteKastOppdatererSpiller() {
		spill.startSpill();
		
		assertEquals(1, spiller1.getAntallKast());
		
		spill.utforNesteKast(beholdIngenTerninger);
		assertEquals(2, spiller1.getAntallKast());
		
		assertFalse(spiller1.ferdigMedRunde());
		
		assertEquals(0, spiller2.getAntallKast());
		
		spill.utforNesteKast(beholdAlleTerninger);
		assertEquals(2, spiller1.getAntallKast()); //spiller1 skal ikke ha kastet flere ganger
		assertTrue(spiller1.ferdigMedRunde());
		
		assertEquals(1, spiller2.getAntallKast());
	}
	
	@Test
	public void bytterSpillerHvisAktuellSpillerHarKastetTreGanger() {
		spill.startSpill();
		
		spill.utforNesteKast(beholdIngenTerninger);
		spill.utforNesteKast(beholdIngenTerninger);
		assertEquals(spiller1, spill.getAktivSpiller());
		
		spill.utforNesteKast(beholdIngenTerninger);
		assertEquals(spiller2, spill.getAktivSpiller());
	}

}
