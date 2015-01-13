package domain.dataInterface;

import data.CtrlBuscaminesBD;
import data.CtrlCasellaBD;
import data.CtrlJugadorBD;
import data.CtrlNivellBD;
import data.CtrlUsuariRegistratBD;

public class CtrlDataFactory {
	private static CtrlDataFactory instance = null;
	private CtrlNivell ctrlNivell = null;
	private CtrlUsuariRegistrat ctrlUsuariRegistrat = null;
	private CtrlJugador ctrlJugador = null;
	private CtrlCasella ctrlCasella = null;
	private CtrlBuscamines ctrlBuscamines = null;
	
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
	
	public CtrlCasella getCtrlCasella() {
		if (ctrlCasella == null) ctrlCasella = new CtrlCasellaBD();
		return ctrlCasella;
	}
	public CtrlBuscamines getCtrlBuscamines() {
		if (ctrlBuscamines == null) ctrlBuscamines = new CtrlBuscaminesBD();
		return ctrlBuscamines;
	}
}
