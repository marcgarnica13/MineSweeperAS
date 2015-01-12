package domain.dataInterface;

import data.CtrlNivellBD;

public class CtrlDataFactory {
	private static CtrlDataFactory instance = null;
	private CtrlNivell ctrlNivell = null;
	
	protected CtrlDataFactory() {}
	public static CtrlDataFactory getInstance() {
		if (instance == null) instance = new CtrlDataFactory();
		return instance;
	}
	
	public CtrlNivell getCtrlNivell() {
		if (ctrlNivell == null) ctrlNivell = new CtrlNivellBD();
		return ctrlNivell;
	}
}
