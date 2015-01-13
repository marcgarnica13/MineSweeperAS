package domain.model;

import javax.persistence.Entity;

@Entity
public class TempsEstrategiaPuntuacio implements IEstrategiaPuntuacio {
	
	public long getPuntuacio(int nombreTirades, long initialTime) {
		long currentTime = System.currentTimeMillis();
		return currentTime - initialTime;
	}

}
