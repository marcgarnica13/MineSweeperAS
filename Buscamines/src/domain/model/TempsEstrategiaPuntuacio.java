package domain.model;


public class TempsEstrategiaPuntuacio implements IEstrategiaPuntuacio {
	
	
	public long getPuntuacio(int nombreTirades, long initialTime) {
		long currentTime = System.currentTimeMillis();
		return currentTime - initialTime;
	}

}
