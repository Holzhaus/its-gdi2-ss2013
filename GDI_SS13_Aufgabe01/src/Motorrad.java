public class Motorrad extends Fahrzeug {
	public Motorrad(double laenge, double breite, double leergewicht, Fahrer[] fahrer) {
		super(laenge, breite, leergewicht);
		this.fahrer = new Fahrer[2];
		this.setzeFahrer(fahrer);
	}
}