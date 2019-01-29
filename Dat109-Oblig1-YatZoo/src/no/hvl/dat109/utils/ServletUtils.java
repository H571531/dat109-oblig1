package no.hvl.dat109.utils;

public class ServletUtils {
	
	public static boolean[] checkboxValgTabellTilBooleanTabell(String[] valgt) {
		
		boolean[] valgteTerninger = new boolean[5];
		if(valgt != null) {
			for(String tall: valgt) {
				valgteTerninger[Integer.parseInt(tall)] = true;
			}
		}
		return valgteTerninger;
		
	}

}
