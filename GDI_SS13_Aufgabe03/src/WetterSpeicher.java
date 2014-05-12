/**
 * @author Jan Holthuis
 * @date 27.04.2013
 *
 */
import java.io.*;
import java.util.List;
import java.util.Locale;
public class WetterSpeicher {
	private static final String DATEIPFAD = "messungen.txt";
	public static void leseWerte(WetterContainer container) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(WetterSpeicher.DATEIPFAD));
		} catch (Exception e) {
			System.err.print("Fehler beim Oeffnen der Datei.");
			return;
		}
		try {
			String line = reader.readLine();
			System.out.println("Lese Werte aus \""+WetterSpeicher.DATEIPFAD+"\":");
			while (line != null) {
				String[] splitResult = line.trim().split(":\\s+");
				String[] date = splitResult[0].split("\\.");
				container.addMesswert(new Messwert(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]), Double.parseDouble(splitResult[1])));
				System.out.println(String.format(Locale.ENGLISH, "%d.%d.%d: %f", Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]), Double.parseDouble(splitResult[1])));
				line = reader.readLine();
			}
		} catch (IOException e) {
				System.err.print("Fehler beim Lesen der Datei.");
				return;
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				System.err.print("Fehler beim Lesen der Datei.");
				return;
			}
		}
	}
	public static void speichereWerte(List<Messwert> werte) {
		FileWriter writer;
		try {
			writer = new FileWriter(WetterSpeicher.DATEIPFAD);
		} catch (Exception e) {
			System.err.print("Fehler beim Oeffnen der Datei.");
			return;
		}
		try {
			System.out.println("Speichere Werte in \""+WetterSpeicher.DATEIPFAD+"\":");
			for(Messwert messwert : werte) {
				System.out.println(String.format(Locale.ENGLISH, "%d.%d.%d: %f", messwert.getTag(), messwert.getMonat(), messwert.getJahr(), messwert.getTemperatur()));
				writer.write(String.format(Locale.ENGLISH, "%d.%d.%d: %f\n", messwert.getTag(), messwert.getMonat(), messwert.getJahr(), messwert.getTemperatur()));
			}
		} catch (Exception e) {
			System.err.print("Fehler beim Schreiben der Datei.");
			return;
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				System.err.print("Fehler beim Schreiben der Datei.");
				return;
			}
		}
	}
}
