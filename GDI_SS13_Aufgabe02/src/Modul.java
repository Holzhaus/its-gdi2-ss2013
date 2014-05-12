public class Modul implements CreditPointI {
	private String name;
	private Lehrveranstaltung[] lehrveranstaltungen;
	public Modul(String name, Lehrveranstaltung[] lehrveranstaltungen) {
		this.name = name;
		this.lehrveranstaltungen = lehrveranstaltungen;
	}
	@Override
	public String getName() {
		// Name zurückgeben
		return this.name;
	}
	@Override
	public int getCPs() {
		// CPs aller Lehrveranstaltungen dieses Moduls addieren und zurückgeben
		int cps = 0;
		for(Lehrveranstaltung l : this.lehrveranstaltungen) {
			if(l!=null) {
				cps += l.getCPs();
			}
		}
		return cps;
	}

}
