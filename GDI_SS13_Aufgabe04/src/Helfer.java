/**
 * @author Jan Holthuis
 * Datum: 06.05.2013
 *
 */
public class Helfer extends Person {
	private boolean ausgebildet;
	private Patient patient;
	public Helfer(int nummer, String name, String strasse, String ort, boolean ausgebildet) {
		super(nummer, name, strasse, ort);
		this.ausgebildet = ausgebildet;
	}
	/**
	 * @return the ausgebildet
	 */
	public boolean isAusgebildet() {
		return ausgebildet;
	}
	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}
	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public boolean isGeeignet(Patient patient) {
		if((this.getPatient()==null) &&
			(patient.getOrt() == this.getOrt()) &&
			((patient.getPflegestufe()==Patient.Pflegestufe.I) || this.isAusgebildet())) {
				return true;
		}
		return false;
	}
}