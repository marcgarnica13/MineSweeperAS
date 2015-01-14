package domain.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TempsEstrategiaPuntuacio implements IEstrategiaPuntuacio {
	
	@Id
	@GeneratedValue
	private long id;
	@Basic
	private int maxTime = 1000;
	
	public long getPuntuacio(int nombreTirades, long initTime) {
		long currentTime = System.currentTimeMillis()/1000;
		System.out.println("CURRENT TIME: " + currentTime);
		return maxTime - (currentTime - initTime/1000);
	}

}
