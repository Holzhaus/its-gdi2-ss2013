/**
 * @author Jan Holthuis
 * Datum: 06.05.2013
 *
 */

public class Patient extends Person {

	private Pflegestufe pflegestufe;
	private Helfer helfer;
	public enum Pflegestufe {
		I, II, III;
	}
	public Patient(int nummer, String name, String strasse, String ort, Pflegestufe pflegestufe) {
		super(nummer, name, strasse, ort);
		this.pflegestufe = pflegestufe;
	}
	/**
	 * @return the pflegestufe
	 */
	public Pflegestufe getPflegestufe() {
		return pflegestufe;
	}
	/**
	 * @return the helfer
	 */
	public Helfer getHelfer() {
		return helfer;
	}
	/**
	 * @param helfer the helfer to set
	 */
	public void setHelfer(Helfer helfer) {
		this.helfer = helfer;
	}
}
