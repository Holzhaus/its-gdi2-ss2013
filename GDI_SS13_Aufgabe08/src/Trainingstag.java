/**
 * @author Jan Holthuis
 * Datum: 02.06.2013
 *
 */
import java.io.Serializable;
public class Trainingstag implements Serializable {
	private static final long serialVersionUID = 8797036872750362848L; //Autogeneriert
	private int tagdesjahres;
	private int[] geraetegewichte = new int[10];
	private int gesamtgewicht = 0;
	public Trainingstag(int tagdesjahres, int[] gewichte) {
		if(tagdesjahres<=0 || tagdesjahres>365) {
			throw new IllegalArgumentException("Tag des Jahres muss zwischen 1 und 365 liegen.");
		}
		if(gewichte.length!=10) {
			throw new IllegalArgumentException("Es muessen genau 10 Geraetegewichte pro Tag erfasst werden.");
		}
		for(int i: gewichte) {
			if(i<0  || i>500 || i%2!= 0) {
				throw new IllegalArgumentException("Alle Gewichte muessen zwischen 0 und 500 liegen und durch 2 teilbar sein.");
			}
		}
		this.tagdesjahres = tagdesjahres;
		this.geraetegewichte = gewichte;
		for(int gewicht: this.geraetegewichte) {
			this.gesamtgewicht += gewicht;
		}
	}
	public int getTagDesJahres() {
		return this.tagdesjahres;
	}
	public int[] getGeraetegewichte() {
		return this.geraetegewichte;
	}
	public int getGesamtgewicht() {
		return this.gesamtgewicht;
	}
	public double getDurchschnittsgewicht() {
		return this.gesamtgewicht/10;
	}
}
