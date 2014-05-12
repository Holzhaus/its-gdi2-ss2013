/**
 * @author Jan Holthuis
 * Datum: 06.05.2013
 *
 */
public class Person {
	private int nummer;
	private String name;
	private String strasse;
	private String ort;
	public Person(int nummer, String name, String strasse, String ort) {
		this.nummer = nummer;
		this.name = name;
		this.strasse = strasse;
		this.ort = ort;
	}
	/**
	 * @return the nummer
	 */
	public int getNummer() {
		return nummer;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the strasse
	 */
	public String getStrasse() {
		return strasse;
	}
	/**
	 * @return the ort
	 */
	public String getOrt() {
		return ort;
	}
}
