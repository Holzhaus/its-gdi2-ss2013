public class Pkw extends Fahrzeug {
	public Pkw(double laenge, double breite, double leergewicht, Fahrer[] fahrer) {
		super(laenge, breite, leergewicht);
		this.fahrer = new Fahrer[4];
		this.setzeFahrer(fahrer);
	}
}