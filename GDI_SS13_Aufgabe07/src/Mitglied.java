/**
 * @author Jan Holthuis
 * Datum: 16.05.2013
 *
 */

import java.util.ArrayList;
public class Mitglied {
	private String name;
	private int alter;
	private Bankverbindung bankverbindung;
	private Sportabteilung abteilung;
	private int abteilungMitgliedschaftsdauer;
	private Mitglied ehepartner;
	public Altergruppe getAltersgruppe() { return null; }
	public double berechneBeitrag() {return 0.0; }
	public void wechsleAbteilung() {}
}
public class Sportabteilung {
	private String name;
	private double beitrag;
	private Altersgruppe[] altersgruppen;
	public Mitglied[] mitgliederZeigen(Sortierung sortierung) {}
}
public class Bankverbindung {
	private int kontonummer;
	private int blz;
	private String bank;
}
public enum Altersgruppe {
	KIND, JUGENDLICHER, ERWACHSENER, SENIOR
}
public enum Sortierung {
	NACHNAME, ALTER, SPORTABTEILUNG, BEITRAGSHOEHE
}
public class MitgliederVerwaltung {
	private ArrayList<Sportabteilung> sportabteilungen;
	private ArrayList<Mitglied> mitglieder;
	private double grundbeitrag;
	public double berechneEinnahmen(int jahr) {}
	public void bucheGebuehrenAb() {}
	public Mitglied[] getMitglieder(Sortierung sortierung) {}
	public Mitglied[] getAbteilungsMitglieder(Sportabteilung, abteilung, Sortierung sortierung) {}
	public void addMitglied(Mitglied mitglied) {}
	public void removeMitglied(Mitglied mitglied) {}
}
public class FitPlusUI {
	private MitgliederVerwaltung verwaltung;
	public void main(String[] argv) {}
	public void zeigeMitglieder(Sortierung sortierung) {}
	public void zeigeAbteilungsmitglieder(Sortierung sortierung) {}
	public void zeigeEinnahmen() {}
	public void zeigeVorausschau() {}
	public void addMitglied() {}
	public void removeMitglied() {}
}