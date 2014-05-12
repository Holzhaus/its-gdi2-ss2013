import java.util.Map;

public class UI {
	public static double rand(double a, double b) {
		return (Math.random()*(b-a))+a;
	}
	
	private static Fahrer[] generiereFahrer(int maxAnzahl, int minGepaeckgewicht, int maxGepaeckgewicht) {
		// Hilfsfunktion um schnell Fahrer für die Fahrzeugsklasse zu generieren
		int anzahl = (int)Math.round(UI.rand(1,maxAnzahl));
		Fahrer[] fahrer = new Fahrer[anzahl];
		for(int i = 0; i<anzahl; i++) {
			fahrer[i] = new Fahrer(UI.rand(40,120), new Gepaeckstueck(UI.rand(minGepaeckgewicht,maxGepaeckgewicht)));
		}
		return fahrer;
	}
	public static void main(String[] args) {
		Faehre faehre = new Faehre(18000,1800000);
		// Zufällig Fahrzeuge inklusive Fahrer, ggf. Beifahrer und Gepäck generieren
		Fahrzeug fahrzeug;
		for(int i = 0; i<=(int)Math.round(UI.rand(2,100)); i++) {
			switch((int)Math.round(UI.rand(0,3))) {
				case 0:
					fahrzeug = new Lkw(UI.rand(8,40), UI.rand(3,4.5), UI.rand(7500,20000), generiereFahrer(3,500,2000));
					break;
				case 1:
					fahrzeug = new Pkw(UI.rand(3,7), UI.rand(2,4), UI.rand(1000,2800), generiereFahrer(4,100,300));
					break;
				case 2:
					fahrzeug = new Motorrad(UI.rand(1.5,4), UI.rand(1,3), UI.rand(150,400), generiereFahrer(2,10,50));
					break;
				default:
					fahrzeug = new Fahrrad(UI.rand(1,3), UI.rand(0.5,1.5), UI.rand(5,20), generiereFahrer(1,1,30));
					break;
			}
			faehre.fahrzeugHinzufuegen(fahrzeug);
		}
		// Ausgeben
		UI.ausgabe(faehre);
	}
	public static void ausgabe(Faehre faehre) {
		// Beladene Fahrzeuge
		String result = "";
		for (Map.Entry<String, Integer> entry : faehre.leseAnzahlFahrzeuge().entrySet()) {
			if(!result.equals("")) {
				result += " / ";
			}
			result += entry.getValue() + "x " + entry.getKey();
		}
		System.out.println("Beladene Fahrzeuge: "+result);
		// Weitere Ausgaben
		System.out.printf("Aktuelle Nutzflaeche: %d m2\n",(int)Math.floor(faehre.leseNutzflaeche()));
		System.out.printf("Aktuelles Nutzgewicht: %d kg\n",(int)Math.floor(faehre.leseNutzgewicht()));
		System.out.printf("Durchschnittliche Nutzfläche: %d m2\n",(int)Math.floor(faehre.leseDurchschnittlNutzflaeche()));
		System.out.printf("Durchschnittliche Nutzgewicht: %d kg\n",(int)Math.floor(faehre.leseDurchschnittlNutzgewicht()));
		System.out.printf("Anzahl Fahrzeuge (Prognose): %d\n",(int)Math.floor(faehre.schaetzeZuladbareFahrzeuge()));
	}
}