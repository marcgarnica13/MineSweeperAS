package domain.adapters;



public class ServicesLocator {
	private static ServicesLocator instance = null;
	private ServeiMissatgeria serveiMissatge = null;
	
	protected ServicesLocator() {}
	public static ServicesLocator getInstance() {
		if (instance == null) instance = new ServicesLocator();
		return instance;
	}
	
	public ServeiMissatgeria getServeiMissatgeria() {
		if (serveiMissatge == null) serveiMissatge = new ServeiMissatgeria();
		return serveiMissatge;
	}

}
