package domain.dataInterface;

import data.CtrlNivellBD;
import data.CtrlUsuariRegistratBD;

public class CtrlDataFactory {
	private static CtrlDataFactory instance = null;
	private CtrlNivell ctrlNivell = null;
	private CtrlUsuariRegistrat ctrlUsuariRegistrat = null;
	
	protected CtrlDataFactory() {}
	public static CtrlDataFactory getInstance() {
		if (instance == null) instance = new CtrlDataFactory();
		return instance;
	}
	
	public CtrlNivell getCtrlNivell() {
		if (ctrlNivell == null) ctrlNivell = new CtrlNivellBD();
		return ctrlNivell;
	}
	
	public CtrlUsuariRegistrat getCtrlUsuariRegistrat() {
		if (ctrlUsuariRegistrat == null) ctrlUsuariRegistrat =  new CtrlUsuariRegistratBD();
		return ctrlUsuariRegistrat;
	}
}
