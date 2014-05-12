/**
 * @author Jan Holthuis
 * @date 27.04.2013
 *
 */
public class WetterUI {
	public static void main(String[] args) {
		WetterContainer container = new WetterContainer();
		//WetterSpeicher.leseWerte(container);
		// Beispielwerte
		container.addMesswert(new Messwert(14,12,2012,10.0));
		container.addMesswert(new Messwert(15,2,2013,8.0));
		container.addMesswert(new Messwert(16,2,2013,13.4));
		container.addMesswert(new Messwert(17,2,2013,14.5));
		WetterSpeicher.speichereWerte(container.getMesswerte());
	}

}
