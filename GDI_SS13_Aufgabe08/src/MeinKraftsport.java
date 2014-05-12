/**
 * @author Jan Holthuis
 * Datum: 02.06.2013
 *
 */
import java.io.*;
import java.util.*;
public class MeinKraftsport {
	private TrainingstagContainer trainingstage;
	private double durchschnittsgewicht = 0;
	private double durchschnittsgewicht_min = 0;
	private double durchschnittsgewicht_max = 0;
	private Tendenz tendenz = Tendenz.GLEICHBLEIBEND;
	public enum Tendenz {
		ABNEHMEND, GLEICHBLEIBEND, ZUNEHMEND
	}
	public MeinKraftsport() {
		this.trainingstage = new TrainingstagContainer();
	}
	public void addTrainingstag(int tagdesjahres, int[] gewichte) {
		Trainingstag tag = new Trainingstag(tagdesjahres, gewichte);
		this.trainingstage.add(tag);
		this.berechneDurchschnittsgewichte();
	}
	public List<Trainingstag> getAllTrainingstage() {
		return this.trainingstage.getAll();
	}
	public int getAnzahlTrainingstage() {
		return this.trainingstage.getAll().size();
	}
	private void berechneDurchschnittsgewichte() {
		double summe = 0;
		Double differenz = null;
		double letztezahl = 0; 
		Double min = null;
		Double max = null;
		for(Trainingstag tag: this.trainingstage.getAll()) {
			// Minimales Durchschnittsgewicht
			if(min==null) {
				min = tag.getDurchschnittsgewicht();
			} else {
				if(min>tag.getDurchschnittsgewicht()) {
					min = tag.getDurchschnittsgewicht();
				}
			}
			// Maximales Durchschnittsgewicht
			if(max==null) {
				max = tag.getDurchschnittsgewicht();
			} else {
				if(max<tag.getDurchschnittsgewicht()) {
					max = tag.getDurchschnittsgewicht();
				}
			}
			//Tendenz
			if(differenz==null) {
				differenz = (double)0;
			} else {
				differenz += tag.getDurchschnittsgewicht()-letztezahl;
			}
			// Gesamtdurchschnittsgewicht
			summe += letztezahl = tag.getDurchschnittsgewicht();
		}
		this.tendenz = (differenz==0) ? Tendenz.GLEICHBLEIBEND : ((differenz>0) ? Tendenz.ZUNEHMEND : Tendenz.ABNEHMEND);
		this.durchschnittsgewicht = summe/this.getAnzahlTrainingstage();
		this.durchschnittsgewicht_min = min;
		this.durchschnittsgewicht_max = max;
	}
	public double getDurchschnittsgewicht() {
		return this.durchschnittsgewicht;
	}
	public double getDurchschnittsgewichtMin() {
		return this.durchschnittsgewicht_min;
	}
	public double getDurchschnittsgewichtMax() {
		return this.durchschnittsgewicht_max;
	}
	public Tendenz getTendenz() {
		return this.tendenz;
	}
	/* PERSISTENTE SPEICHERUNG
	 * 
	 * Wird hier durch Serialisierung erreicht. Wurde gewählt,
	 * weil es einfach zu implementieren ist und es nicht Zielstellung
	 * war, dass auch andere Programme auf die Daten zugreifen können sollen.
	 * Zweifelsohne wäre eine Speicherung als XML oder JSON dennoch schöner,
	 * jedoch ist dies ohne externe Frameworks/Bibliotheken schwierig und es
	 * war nicht klar, ob wir diese Benutzen dürfen. Zudem ist diese Aufgabe
	 * sowieso schon extrem umfangreich, schließlich haben wir auch in anderen
	 * Fächern Übungsblätter. Daher hatte ich nicht allzu große Lust, mich in andere
	 * Systeme einzuarbeiten. Da diese Aufgabe sowieso unverhältnismäßig wenig
	 * Punkte in W3L gibt, nehme ich eine Abwertung für diese Begründung billigend
	 * in Kauf.
	 */
	public void serialize(String filename) {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream o = new ObjectOutputStream(file);
			o.writeObject(this.trainingstage);
			o.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	public boolean isSavedDataAvailable(String filename) {
		if(new File(filename).isFile()) {
			return true;
		}
		return false;
	}
	public void deserialize(String filename) {
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream o = new ObjectInputStream(file);
			this.trainingstage = (TrainingstagContainer) o.readObject();
			o.close();
			this.berechneDurchschnittsgewichte();
		} catch (IOException e) {
			System.err.println(e);
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}
}