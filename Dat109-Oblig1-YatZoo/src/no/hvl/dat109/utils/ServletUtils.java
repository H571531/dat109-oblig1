package no.hvl.dat109.utils;

public class ServletUtils {
	
	/**
	 * Hjelpemetode som oversetter en tabell som inneholder tall med index til checkboxer i html-skjema som er haket av
	 *  til en tabell med boolske verdier, der en gitt indeks settes til true
	 * @param valgt String[] fra html-skjema med valgte checkboxes
	 * @return tabell med boolean der valgte indekser er true
	 */
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
