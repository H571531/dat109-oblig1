package no.hvl.dat109.spill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SpillerTest {
	
	YatzooSpill spill;
	Spiller spiller;
	TerningKopp kopp;
	
	final boolean[] beholdAlleTerninger = {true, true, true, true, true};
	final boolean[] beholdIngenTerninger = {false, false, false, false, false};
	
	
	@Before
	public void setup() {
		spiller = new Spiller("testSpiller");
		kopp = new TerningKopp(5);
		
	}

	@Test
	public void spillerErFerdigEtterTreKast() {
		
		
		assertFalse(spiller.ferdigMedRunde());
		
		spiller.kastTerninger(kopp, beholdIngenTerninger, 0);
		assertFalse(spiller.ferdigMedRunde());
		
		spiller.kastTerninger(kopp, beholdIngenTerninger, 0);
		assertFalse(spiller.ferdigMedRunde());
		
		spiller.kastTerninger(kopp, beholdIngenTerninger, 0);
		assertTrue(spiller.ferdigMedRunde());
	}
	
	@Test
	public void spillerErFerdigHvisAlleFemTerningerErValgt() {
		assertFalse(spiller.ferdigMedRunde());
		spiller.kastTerninger(kopp, beholdIngenTerninger, 0);
		assertFalse(spiller.ferdigMedRunde());
		
		spiller.kastTerninger(kopp, beholdAlleTerninger, 0);
		assertTrue(spiller.ferdigMedRunde());
	}
	
	@Test
	public void spillerHarRettSum() {
		assertEquals(0, spiller.beregnSum());
		
		Integer[] testResultater = {1,1,1,1,1,1,1,1,1,0,0,0};
		spiller.setResultater(testResultater);
		assertEquals(9, spiller.beregnSum());
		
		Integer[] testResultaterFullScore = {5, 5, 5, 5, 5, 5, 3, 4, 4, 5, 5, 10};
		spiller.setResultater(testResultaterFullScore);
		assertEquals(61, spiller.beregnSum());
		
	}
	
	@Test
	public void antallKastOppdateres() {
		assertEquals(0, spiller.getAntallKast());
		
		spiller.kastTerninger(kopp, beholdIngenTerninger, 0);
		assertEquals(1, spiller.getAntallKast());
		
		spiller.kastTerninger(kopp, beholdIngenTerninger, 0);
		assertEquals(2, spiller.getAntallKast());
		
		
		spiller.kastTerninger(kopp, beholdIngenTerninger, 0);
		assertEquals(3, spiller.getAntallKast());

	}
}
