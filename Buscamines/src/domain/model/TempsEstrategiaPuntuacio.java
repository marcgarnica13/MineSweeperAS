package domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TempsEstrategiaPuntuacio implements IEstrategiaPuntuacio {
	
	@Id
	@GeneratedValue
	private long id;
	
	public long getPuntuacio(int nombreTirades, long initialTime) {
		long currentTime = System.currentTimeMillis();
		return currentTime - initialTime;
	}

}
