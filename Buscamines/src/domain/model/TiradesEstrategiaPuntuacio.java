package domain.model;

import java.sql.Time;

public class TiradesEstrategiaPuntuacio implements IEstrategiaPuntuacio {
	
	private int maxTirades = 500;
	
	public int getPuntuacio(int nombreTirades, Time initialTime) {
		return (maxTirades - nombreTirades);
	}

}
