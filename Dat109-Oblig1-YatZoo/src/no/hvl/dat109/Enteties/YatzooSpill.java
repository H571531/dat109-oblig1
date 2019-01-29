package no.hvl.dat109.Enteties;

import java.util.List;

public class YatzooSpill {
	
private List <Spiller> spillere;
private Terning terning;
private int rundenr;

public YatzooSpill(Terning terning, List<Spiller> spillere) {
	this.spillere=spillere;
	this.terning=terning;
	rundenr=0;
	
}

	public void start(){
		String vinner=" ";
		while(rundenr<12) {
			spillRunde();
			rundenr++;
			}
		vinner=hvemVant();
		}
	
	private void spillRunde() {
		spillere.forEach(s->s.spillRunde(rundenr,terning));
	}

	private String hvemVant() {
		spillere.stream().map(s->s.getSum());
		return null;
	}

	
	
}

