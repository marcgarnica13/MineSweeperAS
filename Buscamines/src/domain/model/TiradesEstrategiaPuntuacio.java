package domain.model;

import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity
public class TiradesEstrategiaPuntuacio implements IEstrategiaPuntuacio {
	@Basic
	private int maxTirades = 500;
	
	public long getPuntuacio(int nombreTirades, long initialTime) {
		if ((maxTirades - nombreTirades) > 0) return maxTirades - nombreTirades;
		return 0;
	}

}
