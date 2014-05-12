abstract class Fahrzeug {
	protected Fahrer[] fahrer;
	protected double leergewicht;
	protected double laenge;
	protected double breite;
	public Fahrzeug(double laenge, double breite, double leergewicht) {
		this.laenge = laenge;
		this.breite = breite;
		this.leergewicht = leergewicht;
	}
	public double leseGewicht() {
		// Gewicht des Fahrzeugs inklusive Fahrer, Beifahrer und Gepäck ausgeben.
		double gewicht = this.leergewicht;
		for (Fahrer f: this.fahrer) {
			if(f!=null){
				gewicht += f.leseGewicht();
				if( f.hatGepaeck() ) {
					gewicht += f.leseGepaeck().leseGewicht();
				}
			}
		}
		return gewicht;
	}
	public double leseFlaeche() {
		return this.laenge*this.breite;
	}
	protected void setzeFahrer(Fahrer[] fahrer) {
		if (this.fahrer.length>=fahrer.length) {
			for (int i = 0; i<fahrer.length; i++) {
				this.fahrer[i] = fahrer[i];
			}
		}
	}
}