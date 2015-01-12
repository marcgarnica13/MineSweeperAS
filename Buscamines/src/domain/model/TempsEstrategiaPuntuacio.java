package domain.model;

import java.sql.Time;

public class TempsEstrategiaPuntuacio implements IEstrategiaPuntuacio {
	
	
	public long getPuntuacio(int nombreTirades, long initialTime) {
		long currentTime = System.currentTimeMillis();
		return currentTime - initialTime;
	}

}
