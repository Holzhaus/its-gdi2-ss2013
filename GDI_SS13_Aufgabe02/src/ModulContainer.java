import java.util.ArrayList;
public class ModulContainer {
	private ArrayList<Modul> module = new ArrayList<Modul>();
	public void addModul(Modul modul) {
		this.module.add(modul);
	}
	public ArrayList<Modul> get() {
		// Alle Elemente dieser ArrayList zurückgeben
		return this.module;
	}
}
