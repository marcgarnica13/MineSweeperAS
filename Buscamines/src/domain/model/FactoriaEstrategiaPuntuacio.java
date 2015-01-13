package domain.model;


public class FactoriaEstrategiaPuntuacio {
	
	private static FactoriaEstrategiaPuntuacio instance = null;
	private IEstrategiaPuntuacio estrategiaTemps = null;
	private IEstrategiaPuntuacio estrategiaTirades = null;
	
	public int getIndexEstrategiaPuntuacio() {
		int aux = (1+(int)Math.random()*2);
		if(aux%2 == 0) {
			if(estrategiaTemps == null) estrategiaTemps = new TempsEstrategiaPuntuacio();
			return 1;
		} else {
			if(estrategiaTirades == null) estrategiaTirades = new TiradesEstrategiaPuntuacio();
			return 2;
		}
		
	}
	
	public IEstrategiaPuntuacio getEstrategiaPuntuacio(int index) {
		switch (index) {
		case 1:
			return estrategiaTemps;
		case 2:
			return estrategiaTirades;
		default:
			return null;
		}
	}

	public static FactoriaEstrategiaPuntuacio getInstance() {
		if (instance == null) instance = new FactoriaEstrategiaPuntuacio();
		return instance;
	}



}
