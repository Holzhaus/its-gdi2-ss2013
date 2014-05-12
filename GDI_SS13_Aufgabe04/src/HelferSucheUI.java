/**
 * @author Jan Holthuis
 * Datum: 06.05.2013
 *
 */

public class HelferSucheUI {
	public static void main(String[] args) {
		// Personen hinzufügen
		Personenverwaltung pvw = new Personenverwaltung();
		int i = 0;
		pvw.addPerson(new Helfer(i++, "Jan Holthuis", "Universitaetsstrasse 150", "Bochum", true));
		pvw.addPerson(new Helfer(i++, "Herbert Mies", "Hoffnungstr. 18", "Essen", false));
		pvw.addPerson(new Helfer(i++, "Philipp Mueller", "Borsigstrasse 5", "Dortmund", false));
		pvw.addPerson(new Helfer(i++, "Django Unchained", "Candyland Street 1", "Candyland", true));
		pvw.addPerson(new Helfer(i++, "Dr. King Schultz", "Candyland Street 1", "Candyland", false));
		pvw.addPerson(new Patient(i++, "Calvin Candie", "Candyland Street 1", "Candyland", Patient.Pflegestufe.III));
		pvw.addPerson(new Patient(i++, "Peter", "Candyland Street 1", "Candyland", Patient.Pflegestufe.II));
		pvw.addPerson(new Patient(i++, "Dennis Giemsch", "Rheinische Strasse 135", "Dortmund", Patient.Pflegestufe.III));
		pvw.addPerson(new Patient(i++, "Broomhilda von Shaft", "Musterweg 13", "Dortmund", Patient.Pflegestufe.I));
		pvw.addPerson(new Patient(i++, "Mackie Messer", "Oxford Street 5", "London", Patient.Pflegestufe.I));
		// Personen vermitteln
		HelferSuche.setHelfer(pvw.getPatienten(), pvw.getHelfer());
		// Patienten ausgeben
		System.out.printf("| %20s | %30s | %20s | %5s | %17s | %s\n","NAME","STRASSE","ORT","#","AUSB./STUFE","STATUS");
		for(Patient patient : pvw.getPatienten()) {
			HelferSucheUI.printPatient(patient);
		}
		for(Helfer helfer : pvw.getHelfer()) {
			if (helfer.getPatient()==null) {
				System.out.print("| ");
				HelferSucheUI.printHelfer(helfer);
			}
		}
	}
	public static void printPatient(Patient patient) {
		System.out.printf("| %20s | %30s | %20s | %5d | %17s | %s\n",patient.getName(), patient.getStrasse(), patient.getOrt(), patient.getNummer(), patient.getPflegestufe().toString(), ((patient.getHelfer()==null) ? "Patient ohne Helfer" : "Patient von "+patient.getHelfer().getName()));
		if(patient.getHelfer()!=null) {
			System.out.print("->");
			HelferSucheUI.printHelfer(patient.getHelfer());
		}
		
	}
	public static void printHelfer(Helfer helfer) {
		System.out.printf("%20s | %30s | %20s | %5d | %17s | %s\n",helfer.getName(), helfer.getStrasse(), helfer.getOrt(), helfer.getNummer(), (helfer.isAusgebildet() ? "ausgebildet" : "nicht ausgebildet"), ((helfer.getPatient()==null) ? "Helfer ohne Patient" : "Helfer von "+helfer.getPatient().getName()));

	}

}
