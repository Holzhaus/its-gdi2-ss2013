abstract class Fahrzeuginhalt {
	// Gibt es, da sowohl Gepäck als auch Fahrer die leseGewicht-Methode brauchen
	private double gewicht;
	public Fahrzeuginhalt(double gewicht) {
		this.gewicht = gewicht;
	}
	public double leseGewicht() {
		return this.gewicht;
	}
}