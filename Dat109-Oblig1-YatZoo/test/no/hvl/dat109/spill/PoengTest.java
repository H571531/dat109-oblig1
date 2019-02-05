package no.hvl.dat109.spill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat109.utils.Dyr;
import no.hvl.dat109.utils.PoengUtils;

public class PoengTest {
	
	TerningKopp kopp;
	int runde;
	
	@Before
	public void setup() {
		kopp = new TerningKopp(5);
	}

	@Test
	public void antallLoverGirRettPoeng() {
		
		
		setAlleTerningerTilGittDyr(Dyr.LOVE);
		assertEquals(5, PoengUtils.beregnRunde(0, kopp));
		
		kopp.getTerninger()[0].setVerdi(Dyr.GRIS);
		assertEquals(4, PoengUtils.beregnRunde(0, kopp));
		
		kopp.getTerninger()[1].setVerdi(Dyr.HVAL);
		assertEquals(3, PoengUtils.beregnRunde(0, kopp));
		
		for(int i = 0; i < 5; i++) {
			setGittAntallTerningerTilGittDyr(Dyr.LOVE, i);
			assertEquals(i, PoengUtils.beregnRunde(0, kopp));
			assertNotEquals((i+1), PoengUtils.beregnRunde(0, kopp));
		}
	}
	
	@Test
	public void antallHvalerGitRettPoeng() {
		setAlleTerningerTilGittDyr(Dyr.HVAL);
		assertEquals(5, PoengUtils.beregnRunde(5, kopp));
		
		for(int i = 0; i < 5; i++) {
			setGittAntallTerningerTilGittDyr(Dyr.HVAL, i);
			assertEquals(i, PoengUtils.beregnRunde(5, kopp));
			assertNotEquals((i+1), PoengUtils.beregnRunde(5, kopp));
		}
	}
	
	@Test
	public void minstTreLikeGirTrePoeng() {
		
		kopp.getTerninger()[0].setVerdi(Dyr.LOVE);
		kopp.getTerninger()[1].setVerdi(Dyr.GRIS);
		kopp.getTerninger()[2].setVerdi(Dyr.HVAL);
		kopp.getTerninger()[3].setVerdi(Dyr.ELEFANT);
		kopp.getTerninger()[4].setVerdi(Dyr.SLANGE);
		
		
		assertEquals(0, PoengUtils.beregnRunde(6, kopp));
		
		kopp.getTerninger()[1].setVerdi(Dyr.LOVE);
		assertEquals(0, PoengUtils.beregnRunde(6, kopp));
		
		kopp.getTerninger()[2].setVerdi(Dyr.LOVE); //Tre løver
		assertEquals(3, PoengUtils.beregnRunde(6, kopp));
		
		kopp.getTerninger()[3].setVerdi(Dyr.LOVE); //Fire løver
		assertEquals(3, PoengUtils.beregnRunde(6, kopp));
		
		kopp.getTerninger()[4].setVerdi(Dyr.LOVE); //Fem løver
		assertEquals(3, PoengUtils.beregnRunde(6, kopp));
	}
	
	@Test
	public void minstFireLikeGirFirePoeng() {
		kopp.getTerninger()[0].setVerdi(Dyr.LOVE);
		kopp.getTerninger()[1].setVerdi(Dyr.GRIS);
		kopp.getTerninger()[2].setVerdi(Dyr.HVAL);
		kopp.getTerninger()[3].setVerdi(Dyr.ELEFANT);
		kopp.getTerninger()[4].setVerdi(Dyr.SLANGE);
		
		
		assertEquals(0, PoengUtils.beregnRunde(7, kopp));
		
		kopp.getTerninger()[1].setVerdi(Dyr.LOVE);
		assertEquals(0, PoengUtils.beregnRunde(7, kopp));
		
		kopp.getTerninger()[2].setVerdi(Dyr.LOVE);
		assertEquals(0, PoengUtils.beregnRunde(7, kopp));
		
		kopp.getTerninger()[3].setVerdi(Dyr.LOVE); //Fire løver
		assertEquals(4, PoengUtils.beregnRunde(7, kopp)); 
		
		kopp.getTerninger()[4].setVerdi(Dyr.LOVE); //Fem løver
		assertEquals(4, PoengUtils.beregnRunde(7, kopp));
	}
	
	@Test
	public void toParGirFirePoeng() {
		kopp.getTerninger()[0].setVerdi(Dyr.LOVE);
		kopp.getTerninger()[1].setVerdi(Dyr.GRIS);
		kopp.getTerninger()[2].setVerdi(Dyr.HVAL);
		kopp.getTerninger()[3].setVerdi(Dyr.ELEFANT);
		kopp.getTerninger()[4].setVerdi(Dyr.SLANGE);
		
		assertEquals(0, PoengUtils.beregnRunde(8, kopp));
		
		kopp.getTerninger()[1].setVerdi(Dyr.LOVE); //To løver, ingen andre like
		assertEquals(0, PoengUtils.beregnRunde(8, kopp));
		
		kopp.getTerninger()[2].setVerdi(Dyr.LOVE); //Tre løver, to ulike
		assertEquals(0, PoengUtils.beregnRunde(8, kopp));
		
		kopp.getTerninger()[3].setVerdi(Dyr.LOVE); //Fire løver, en slange
		assertEquals(0, PoengUtils.beregnRunde(8, kopp));
		
		kopp.getTerninger()[4].setVerdi(Dyr.LOVE); //Fem løver
		assertEquals(0, PoengUtils.beregnRunde(8, kopp));
		
		kopp.getTerninger()[0].setVerdi(Dyr.GRIS);
		kopp.getTerninger()[1].setVerdi(Dyr.GRIS); //Tre løver, to griser
		assertEquals(4, PoengUtils.beregnRunde(8, kopp));
		
	}
	
	@Test
	public void husGirFemPoeng() {
		
		kopp.getTerninger()[0].setVerdi(Dyr.LOVE);
		kopp.getTerninger()[1].setVerdi(Dyr.LOVE);
		kopp.getTerninger()[2].setVerdi(Dyr.GRIS);
		kopp.getTerninger()[3].setVerdi(Dyr.GRIS);
		kopp.getTerninger()[4].setVerdi(Dyr.SLANGE);
		
		assertEquals(0, PoengUtils.beregnRunde(9, kopp));
		
		kopp.getTerninger()[4].setVerdi(Dyr.GRIS); //To løver, Tre griser
		assertEquals(5, PoengUtils.beregnRunde(9,  kopp));
		
		kopp.getTerninger()[4].setVerdi(Dyr.LOVE); // Tre løver, to griser
		assertEquals(5, PoengUtils.beregnRunde(9, kopp));
		
		kopp.getTerninger()[1].setVerdi(Dyr.GRIS); //To løver, tre griser
		assertEquals(5, PoengUtils.beregnRunde(9, kopp));
		
		kopp.getTerninger()[0].setVerdi(Dyr.GRIS); //En løve, fire griser
		assertEquals(0, PoengUtils.beregnRunde(9, kopp));
		
	}
	
	@Test
	public void alleUlikeGirFemPoeng() {
		
		setAlleTerningerTilGittDyr(Dyr.LOVE);
		assertEquals(0, PoengUtils.beregnRunde(10, kopp));
		
		kopp.getTerninger()[0].setVerdi(Dyr.ELEFANT);
		assertEquals(0, PoengUtils.beregnRunde(10, kopp));
		
		kopp.getTerninger()[1].setVerdi(Dyr.GRIS);
		assertEquals(0, PoengUtils.beregnRunde(10, kopp));
		
		kopp.getTerninger()[2].setVerdi(Dyr.HVAL);
		assertEquals(0, PoengUtils.beregnRunde(10, kopp));
		
		kopp.getTerninger()[3].setVerdi(Dyr.PANDA);
		assertEquals(5, PoengUtils.beregnRunde(10, kopp));
		
		kopp.getTerninger()[4].setVerdi(Dyr.SLANGE);
		assertEquals(5, PoengUtils.beregnRunde(10, kopp));
	}
	
	@Test
	public void alleLikeGirTiPoeng() {
		kopp.getTerninger()[0].setVerdi(Dyr.LOVE);
		kopp.getTerninger()[1].setVerdi(Dyr.LOVE);
		kopp.getTerninger()[2].setVerdi(Dyr.LOVE);
		kopp.getTerninger()[3].setVerdi(Dyr.LOVE);
		kopp.getTerninger()[4].setVerdi(Dyr.LOVE);
		
		assertEquals(10, PoengUtils.beregnRunde(11, kopp));
		
		kopp.getTerninger()[4].setVerdi(Dyr.ELEFANT);
		assertEquals(0, PoengUtils.beregnRunde(11, kopp));
		
		setAlleTerningerTilGittDyr(Dyr.ELEFANT);
		assertEquals(10, PoengUtils.beregnRunde(11, kopp));

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
		for(int i = 0; i < kopp.getAntallTerninger(); i++) {
			terning = new Terning();
			terning.setVerdi(dyr);
			kopp.getTerninger()[i] = terning;
		}
		
		
		
		int i = antall;
		while(i < kopp.getAntallTerninger() ) {
			
			if(kopp.getTerninger()[i].getVerdi().equals(dyr)) {
				kopp.getTerninger()[i].kast();
			} else {
				i++;
			}
		}
	}

}
