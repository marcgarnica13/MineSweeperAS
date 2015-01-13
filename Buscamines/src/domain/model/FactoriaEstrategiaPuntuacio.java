package domain.model;


public class FactoriaEstrategiaPuntuacio {
	
	private static FactoriaEstrategiaPuntuacio instance = null;
	private IEstrategiaPuntuacio estrategiaTemps = null;
	private IEstrategiaPuntuacio estrategiaTirades = null;
	
	public IEstrategiaPuntuacio getEstrategiaPuntuacio() {
		int aux = (1+(int)Math.random()*2);
		if(aux%2 == 0) {
			if(estrategiaTemps != null) return estrategiaTemps;
			else {
				estrategiaTemps = new TempsEstrategiaPuntuacio();
				return estrategiaTemps;
			}
		} else {
			if(estrategiaTirades != null) return estrategiaTirades;
			else {
				estrategiaTirades = new TiradesEstrategiaPuntuacio();
				return estrategiaTirades;
			}
		}
		
	}

	public static FactoriaEstrategiaPuntuacio getInstance() {
		if (instance == null) instance = new FactoriaEstrategiaPuntuacio();
		return instance;
	}



}
