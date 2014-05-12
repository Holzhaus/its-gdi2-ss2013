/**
 * @author Jan Holthuis
 * @date 27.04.2013
 *
 */
import java.util.*;
public class WetterContainer {
	private ArrayList<Messwert> messwerte = new ArrayList<Messwert>();
	public void addMesswert(Messwert messwert) {
		this.messwerte.add(messwert);
	}
	public ArrayList<Messwert> getMesswerte() {
		return this.messwerte;
	}
}
