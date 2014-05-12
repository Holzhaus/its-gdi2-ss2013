public class Lkw extends Fahrzeug {
	public Lkw(double laenge, double breite, double leergewicht, Fahrer[] fahrer) {
		super(laenge, breite, leergewicht);
		this.fahrer = new Fahrer[3];
		this.setzeFahrer(fahrer);
	}
}