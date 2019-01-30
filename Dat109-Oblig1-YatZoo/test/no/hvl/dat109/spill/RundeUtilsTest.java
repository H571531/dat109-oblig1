package no.hvl.dat109.spill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.apache.catalina.tribes.util.Arrays;
import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.utils.Dyr;
import no.hvl.dat109.utils.RundeUtils;

public class RundeUtilsTest {
	
	TerningKopp kopp;
	int runde;
	
	@Before
	public void setup() {
		kopp = new TerningKopp(5);
	}

	@Test
	public void antallLoverGirRettPoeng() {
		setAlleTerningerTilGittDyr(Dyr.LOVE);
		assertEquals(5, RundeUtils.beregnRunde(0, kopp));
		
		for(int i = 0; i < 5; i++) {
			setGittAntallTerningerTilGittDyr(Dyr.LOVE, i);
			assertEquals(i, RundeUtils.beregnRunde(0, kopp));
			assertNotEquals((i+1), RundeUtils.beregnRunde(0, kopp));
		}
	}
	
	@Test
	public void antallHvalerGitRettPoeng() {
		setAlleTerningerTilGittDyr(Dyr.HVAL);
		assertEquals(5, RundeUtils.beregnRunde(5, kopp));
		
		for(int i = 0; i < 5; i++) {
			setGittAntallTerningerTilGittDyr(Dyr.HVAL, i);
			assertEquals(i, RundeUtils.beregnRunde(5, kopp));
			assertNotEquals((i+1), RundeUtils.beregnRunde(5, kopp));
		}
	}
	
	private void setAlleTerningerTilGittDyr(Dyr dyr) {
		Terning terning;
		
		for(int i = 0; i < 5; i++) {
			terning = new Terning();
			terning.setVerdi(dyr);
			kopp.getTerninger()[i] = terning;
		}
	}
	
	private void setGittAntallTerningerTilGittDyr(Dyr dyr, int antall) {
		Terning terning;
		for(int i = 0; i < antall; i++) {
			terning = new Terning();
			terning.setVerdi(dyr);
			kopp.getTerninger()[i] = terning;
		}
		
		
		
		int i = antall;
		while(i < kopp.getAntallTerninger()) {
			if(kopp.getTerninger()[i].getVerdi().equals(dyr)) {
				kopp.getTerninger()[i].kast();
			} else {
				i++;
			}
		}
	}

}
