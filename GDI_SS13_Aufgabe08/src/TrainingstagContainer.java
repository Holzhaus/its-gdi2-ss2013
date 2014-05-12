/**
 * @author Jan Holthuis
 * Datum: 02.06.2013
 *
 */
import java.util.*;
import java.io.Serializable;
public class TrainingstagContainer implements Serializable {
	private static final long serialVersionUID = 2234299569839461687L; //Autogeneriert
	TreeMap<Integer,Trainingstag> tage = new TreeMap<Integer,Trainingstag>();
	public void add(Trainingstag trainingstag) {
		if(this.tage.containsKey(trainingstag.getTagDesJahres())) {
			throw new IllegalArgumentException("Für diesen Tag des Jahres sind bereits Daten eingetragen!");
		}
		this.tage.put(trainingstag.getTagDesJahres(),trainingstag);
	}
	public List<Trainingstag> getAll() {
		return new ArrayList<Trainingstag>(this.tage.values());
	}
}
