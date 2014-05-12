public class StudiengangUI {
	/**
	 * @author Jan Holthuis
	 * @version 2013-04-21
	 */
	public static void ausgeben(CreditPointI cpi) {
		System.out.printf("%s \"%s\" (%d CPs)\n", cpi.getClass().getName(), cpi.getName(), cpi.getCPs());
	}
	public static void main(String[] args) {
		/*	Modul "Grundlagen der Informatik" mit 
			- Lehrveranstaltung "Grundlagen der Informatik I" mit 5 CPs
			- Lehrveranstaltung "Grundlagen der Informatik II" mit 5 CPs
			Modul "Mathematik" mit 
			- Lehrveranstaltung "Algebra" mit 5 CPs
			- Lehrveranstaltung "Analysis" mit 5 CPs
			- Lehrveranstaltung "Statistik" mit 5 CPs
			- Lehrveranstaltung "Diskrete Mathe" mit 5 CPs */
		ModulContainer container = new ModulContainer();
		Modul gdi = new Modul("Grundlagen der Informatik", new Lehrveranstaltung[]{
				new Lehrveranstaltung("Grundlagen der Informatik I", 5),
				new Lehrveranstaltung("Grundlagen der Informatik II", 5)
				});
		Modul mathe = new Modul("Mathematik", new Lehrveranstaltung[]{
				new Lehrveranstaltung("Algebra", 5),
				new Lehrveranstaltung("Analysis", 5),
				new Lehrveranstaltung("Statistik", 5),
				new Lehrveranstaltung("Diskrete Mathe", 5)
				});
		Modul personalisierung = new Modul("Nerdmodul", new Lehrveranstaltung[]{
				new Lehrveranstaltung("Jadzia Dax: 'Reciprocating Wavefront Harmonics' (Gastvortrag)", 5),
				new Lehrveranstaltung("Hochtrabender Technobabble in Star Trek", 5)
				});
		container.addModul(gdi);
		container.addModul(mathe);
		container.addModul(personalisierung);
		// Modulcontainer durchgehen und ausgeben
		for(Modul modul : container.get()) {
			StudiengangUI.ausgeben(modul);
		}
	}

}
