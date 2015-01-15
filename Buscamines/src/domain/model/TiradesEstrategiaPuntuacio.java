package domain.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TiradesEstrategiaPuntuacio implements IEstrategiaPuntuacio {
	/*
	 * Hem inclos un id necessari per la DB
	 */
	@Id
	@GeneratedValue
	private long id;
	@Basic
	private int maxTirades = 500;
	
	public long getPuntuacio(int nombreTirades, long initialTime) {
		if ((maxTirades - nombreTirades) > 0) return maxTirades - nombreTirades;
		return 0;
	}

}
