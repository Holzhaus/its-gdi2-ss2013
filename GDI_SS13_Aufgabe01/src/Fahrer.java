public class Fahrer extends Fahrzeuginhalt {
	private Gepaeckstueck gepaeck;
	public Fahrer(double gewicht) {
		/* War nicht sicher, ob jeder (Bei)Fahrer Gepäck hat
		 * oder ob es nur ein Gepäck pro Fahrzeug gibt. Habe auf
		 * Ersteres getippt, aber diesen Constructor mal drin
		 * gelassen. */
		super(gewicht);
	}
	public Fahrer(double gewicht, Gepaeckstueck gepaeck) {
		super(gewicht);
		this.gepaeck = gepaeck;
	}
	public boolean hatGepaeck() {
		if (this.gepaeck == null) {
			return false;
		} else {
			return true;
		}
	}
	public Gepaeckstueck leseGepaeck() {
		return this.gepaeck;
	}
}
