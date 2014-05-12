/**
 * @author Jan Holthuis
 * Datum: 02.06.2013
 *
 */
import java.util.Arrays;
import inout.Console;
public class MeinKraftsportUI {
	public static final String filename = "data.ser";
	MeinKraftsport app = new MeinKraftsport();
	public static int printMenu() {
		System.out.print(
		"-------------------------------------------\n" +
		"Bitte Funktion auswählen: \n" +
		"1: Trainingstag erfassen \n" +
		"2: Liste aller Trainingstage \n" +
		"3: Programm beenden und Daten speichern \n" +
		"Abbruch: 9 \n" +
		"Bitte Ziffer 1, 2, 3 oder 9 eingeben: ");
		int input = Console.readInt();
		System.out.println("-------------------------------------------");
		return input;
	}
	public static int[] readTrainingstag() {
		System.out.println("Geben Sie bitte den Tag des Jahres und anschl. alle 10 Gewichte, jeweils getrennt durch ein Leerzeichen ein: ");
		String[] strdaten = Console.readString().split(" ");
		if(strdaten.length != 11) {
			throw new IllegalArgumentException("Fehlerhafte Eingabe!");
		}
		int[] intdaten = new int[11];
		for (int i = 0; i < 11; i++) {
			intdaten[i] = Integer.parseInt(strdaten[i]);
		}
		return intdaten;
	}
	public static void listeTrainingstage(MeinKraftsport app) {
		// Tabelle mit Trainingstagen
		System.out.println("Tag | Gewichte                                Gesamtgewicht Durchschnittsgewicht");
		System.out.println("----|---------------------------------------------------------------------------");
		for(Trainingstag tag: app.getAllTrainingstage()) {
			System.out.printf("%3d | ", tag.getTagDesJahres());
			for(int i: tag.getGeraetegewichte()) {
				System.out.printf("%3d ",i);
			}
			System.out.printf("%13d           %10.1f\n", tag.getGesamtgewicht(), tag.getDurchschnittsgewicht());
		}
		// Statistiken
		char tendenz;
		switch(app.getTendenz()) {
			case GLEICHBLEIBEND:
				tendenz = 'o';
				break;
			case ZUNEHMEND:
				tendenz = '+';
				break;
			case ABNEHMEND:
				tendenz = '-';
				break;
			default:
				tendenz = '?';
		}
		System.out.printf("\n"+
						"Anzahl Trainingstage: %d\n" +
						"Durchschnittsgewicht aller Trainingstage: %5.1f\n" +
						"Max Durchschnittsgewicht: %5.1f\n" +
						"Min Durchschnittsgewicht: %5.1f\n" +
						"Tendenz aller Trainingstage: %c\n",
						app.getAnzahlTrainingstage(), app.getDurchschnittsgewicht(), app.getDurchschnittsgewichtMax(), app.getDurchschnittsgewichtMin(), tendenz);
	}
	public static void main(String[] args) {
		int input = 0;
		MeinKraftsport app = new MeinKraftsport();
		if(app.isSavedDataAvailable(MeinKraftsportUI.filename)) {
			System.out.println("Zuvor gespeicherte Trainingsdaten gefunden!");
			System.out.println("Wollen Sie die Daten laden? [j,N]");
			if((char)Character.toLowerCase(Console.readChar())==(char)'j') {
				app.deserialize(MeinKraftsportUI.filename);
				System.out.println("Alte Daten geladen!");
			} else {
				System.out.println("Starte neue Datei. Beim Speichern werden alte Daten ueberschrieben!");
			}
		}
		while(input!=9) {
			switch(input = MeinKraftsportUI.printMenu()) {
				case 1:
					// erfasse Trainingstag;
					while(true) {
						try {
							int[] daten = MeinKraftsportUI.readTrainingstag();
							app.addTrainingstag(daten[0], Arrays.copyOfRange(daten, 1, 11));
							break;
						} catch(Exception e) {
							System.err.println(e);
						}
					}
					break;
				case 2:
					MeinKraftsportUI.listeTrainingstage(app);
					break;
				case 3:
					System.out.printf("Speichere Daten in Datei '%s'...\n",MeinKraftsportUI.filename);
					app.serialize(MeinKraftsportUI.filename);
					System.out.println("Daten gespeichert.");
					System.out.println("Auf Wiedersehen!");
					input = 9;
					break;
				case 9:
					System.out.println("Auf Wiedersehen!");
					break;
				default:
					System.out.println("Fehlerhafte Eingabe, bitte erneut eingeben!");
			}
		}
		
	}

}
