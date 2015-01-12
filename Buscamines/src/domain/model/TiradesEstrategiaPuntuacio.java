package domain.model;


public class TiradesEstrategiaPuntuacio implements IEstrategiaPuntuacio {
	
	private int maxTirades = 500;
	
	public long getPuntuacio(int nombreTirades, long initialTime) {
		if ((maxTirades - nombreTirades) > 0) return maxTirades - nombreTirades;
		return 0;
	}

}
