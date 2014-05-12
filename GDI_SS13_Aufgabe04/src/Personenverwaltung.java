/**
 * @author Jan Holthuis
 * Datum: 06.05.2013
 *
 */
import java.util.ArrayList;
public class Personenverwaltung {
	ArrayList<Patient> patienten = new ArrayList<Patient>();
	ArrayList<Helfer> helfer = new ArrayList<Helfer>();
	public void addPerson(Person person) {
		switch(person.getClass().getName()) {
		case "Helfer":
			this.helfer.add((Helfer)person);
			break;
		case "Patient":
			this.patienten.add((Patient)person);
			break;
		}
	}
	public ArrayList<Patient> getPatienten() {
		return this.patienten;
	}
	public ArrayList<Helfer> getHelfer() {
		return this.helfer;
	}
}
