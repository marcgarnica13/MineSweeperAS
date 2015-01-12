package domain.controllers;

import java.io.IOException;
import java.sql.Time;
import java.util.List;
import java.util.Set;

import data.CtrlNivellBD;
import domain.controllers.UcConsultarNivells.TupleNivells;
import domain.dataInterface.CtrlDataFactory;
import domain.dataInterface.CtrlNivell;
import domain.model.Buscamines;
import domain.model.Jugador;
import domain.model.Nivell;
import domain.model.Partida;
import domain.model.UsuariRegistrat;

public class UcJugarPartida {
	
	private Jugador currentPlayer;
	private Partida currentPartida;
	private Long initTime;
	public UcJugarPartida() {
		
	}
	
	public void ferAutenticacio(String username, String pwd) throws IOException {
		new UcLogin().login(username, pwd);
		CtrlDataFactory ctrlDataFactory = CtrlDataFactory.getInstance();
		Jugador jugador;
		jugador = ctrlDataFactory.getCtrlJugador().getJugador(username);
		currentPlayer = jugador;
		
	}
	
	public List<TupleNivells> ObtenirNivells() {
		List<TupleNivells> nivells = null;
		try {
			nivells = new UcConsultarNivells().obtenirNivells();
			return nivells;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	
	public void crearPartida(String nomNivell) {
		int id = Buscamines.getInstance().getNextIdPartida();//TODO
		CtrlDataFactory ctrlDataFactory = CtrlDataFactory.getInstance();
		Nivell nivell;
		nivell = ctrlDataFactory.getCtrlNivell().getNivell(nomNivell);
		Partida partida = new Partida(id, nivell, currentPlayer);
		currentPartida = partida;
		initTime = System.currentTimeMillis();
	}
	
	public List<TupleNivells> consultarNivells() throws IOException {
		return new UcConsultarNivells().obtenirNivells();
	}
	
	public void descobrirCasella(int numF, int numC) {
		
	}
	

}
