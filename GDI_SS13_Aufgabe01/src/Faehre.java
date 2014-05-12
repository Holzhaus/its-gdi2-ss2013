import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class Faehre {
	private ArrayList<Fahrzeug> fahrzeuge = new ArrayList<Fahrzeug>();
	private double nutzflaeche;
	private double nutzgewicht;
	public Faehre(double nutzflaeche, double nutzgewicht) {
		this.nutzflaeche = nutzflaeche;
		this.nutzgewicht = nutzgewicht;
	}
	public Map<String, Integer> leseAnzahlFahrzeuge() {
		// Map mit den Klassennamen und der jeweiligen Anzahl der Instanzen in der ArrayList fahrzeuge erstellen
		Map<String, Integer> fahrzeugtypen = new HashMap<String, Integer>();
		String fname;
		for (Fahrzeug fahrzeug : this.fahrzeuge) {
			fname = fahrzeug.getClass().getName();
			if(fahrzeugtypen.containsKey(fname)) {
				// Wenn Klassenname schon in der Map vorhanden, dann Anzahl um 1 erhöhen
				fahrzeugtypen.put(fname, (fahrzeugtypen.get(fname)+1));
			} else {
				// Sonst neu zur Map hinzufügen
				fahrzeugtypen.put(fname, 1);
			}
		}
		return fahrzeugtypen;
	}
	public double leseNutzflaeche() {
		double flaeche = 0;
		for (Fahrzeug fahrzeug : this.fahrzeuge) {
			flaeche += (fahrzeug.leseFlaeche()*1.5);
		}
		return flaeche;
	}
	public double leseDurchschnittlNutzflaeche() {
		// Arithmetisches Mittel der Fahrzeuggesamtflaechen
		return (this.leseNutzflaeche()/this.fahrzeuge.size());
	}
	public double leseNutzgewicht() {
		double gewicht = 0;
		for (Fahrzeug fahrzeug : this.fahrzeuge) {
			gewicht += (fahrzeug.leseGewicht());
		}
		return gewicht;
	}
	public double leseDurchschnittlNutzgewicht() {
		// Arithmetisches Mittel der Fahrzeuggesamtgewichte
		return (this.leseNutzgewicht()/this.fahrzeuge.size());
	}
	public int schaetzeZuladbareFahrzeuge() {
		// Die pessimistischere Schätzung (nach Gewicht oder nach Fläche) zurückgeben
		int zahl1 = (int) Math.floor((this.nutzgewicht-this.leseNutzgewicht())/this.leseDurchschnittlNutzgewicht());
		int zahl2 = (int) Math.floor((this.nutzflaeche-this.leseNutzflaeche())/this.leseDurchschnittlNutzflaeche());
		if(zahl1 < zahl2) {
			return zahl2;
		} else {
			return zahl1;
		}
	}
	public void fahrzeugHinzufuegen(Fahrzeug fahrzeug) {
		// Fahrzeug hinzufügen, wenn genug Platz und Gewicht frei ist
		if(fahrzeug.leseGewicht()<=(this.nutzgewicht-this.leseNutzgewicht())
		|| (fahrzeug.leseFlaeche()*1.5)<=(this.nutzflaeche-this.leseNutzflaeche())) {
			this.fahrzeuge.add(fahrzeug);
		}
	}
}
