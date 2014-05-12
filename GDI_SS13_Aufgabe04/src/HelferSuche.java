/**
 * @author Jan Holthuis
 * Datum: 06.05.2013
 *
 */

import java.util.ArrayList;
public class HelferSuche {
	public static void setHelfer(ArrayList<Patient> patienten, ArrayList<Helfer> helfer) {
		for(Patient patient : patienten) {
			for(Helfer freiwilliger : helfer) {
				if (freiwilliger.isGeeignet(patient)) {
					freiwilliger.setPatient(patient);
					patient.setHelfer(freiwilliger);
					break;
				}
			}
		}
	}
}
