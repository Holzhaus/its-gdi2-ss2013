class Fahrrad extends Fahrzeug {
	public Fahrrad(double laenge, double breite, double leergewicht, Fahrer[] fahrer) {
		super(laenge, breite, leergewicht);
		this.fahrer = new Fahrer[1];
		this.setzeFahrer(fahrer);
	}
}