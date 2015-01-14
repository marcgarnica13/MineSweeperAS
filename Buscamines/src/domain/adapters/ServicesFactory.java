package domain.adapters;

import data.ServeiMissatgeriaAdapter;


public class ServicesFactory {
	private static ServicesFactory instance = null;
	private IserveiMissatgeriaAdapter serveiMissatgeria = null;
	
	protected ServicesFactory() {}
	public static ServicesFactory getInstance() {
		if (instance == null) instance = new ServicesFactory();
		return instance;
	}
	
	public IserveiMissatgeriaAdapter getServeiMissatgeriaAdapter() {
		if (serveiMissatgeria == null) serveiMissatgeria = new ServeiMissatgeriaAdapter();
		return serveiMissatgeria;
	}

}
