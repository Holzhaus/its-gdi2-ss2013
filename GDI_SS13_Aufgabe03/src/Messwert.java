/**
 * @author Jan Holthuis
 * @date 27.04.2013
 *
 */
public class Messwert {
	private double temperatur;
	private int tag;
	private int monat;
	private int jahr;
	public Messwert(int tag, int monat, int jahr, double temperatur) {
		this.temperatur = temperatur;
		this.tag = tag;
		this.monat = monat;
		this.jahr = jahr;
	}
	public double getTemperatur() {
		return this.temperatur;
	}
	public int getTag() {
		return tag;
	}
	public int getMonat() {
		return monat;
	}
	public int getJahr() {
		return jahr;
	}
}
