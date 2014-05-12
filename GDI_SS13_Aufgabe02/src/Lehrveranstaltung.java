public class Lehrveranstaltung implements CreditPointI {
	private String name;
	private int cps;
	public Lehrveranstaltung(String name, int cps) {
		this.name = name;
		this.cps = cps;
	}
	@Override
	public String getName() {
		// Name zurückgeben
		return this.name;
	}
	@Override
	public int getCPs() {
		//CPs zurückgeben
		return this.cps;
	}

}
