package domain.dataInterface;

import data.CtrlJugadorBD;
import data.CtrlNivellBD;
import data.CtrlUsuariRegistratBD;

public class CtrlDataFactory {
	private static CtrlDataFactory instance = null;
	private CtrlNivell ctrlNivell = null;
	private CtrlUsuariRegistrat ctrlUsuariRegistrat = null;
	private CtrlJugador ctrlJugador = null;
	
	protected CtrlDataFactory() {}
	public static CtrlDataFactory getInstance() {
		if (instance == null) instance = new CtrlDataFactory();
		return instance;
	}
	
	public CtrlNivell getCtrlNivell() {
		if (ctrlNivell == null) ctrlNivell = new CtrlNivellBD();
		return ctrlNivell;
	}
	
	public CtrlJugador getCtrlJugador() {
		if(ctrlJugador == null) ctrlJugador = new CtrlJugadorBD();
		return ctrlJugador;
	}
	public CtrlUsuariRegistrat getCtrlUsuariRegistrat() {
		if (ctrlUsuariRegistrat == null) ctrlUsuariRegistrat =  new CtrlUsuariRegistratBD();
		return ctrlUsuariRegistrat;
	}
}
