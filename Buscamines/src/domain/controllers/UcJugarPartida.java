package domain.controllers;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import data.CtrlNivellBD;
import domain.controllers.UcConsultarNivells.TupleNivells;
import domain.dataInterface.CtrlCasella;
import domain.dataInterface.CtrlDataFactory;
import domain.dataInterface.CtrlNivell;
import domain.model.Buscamines;
import domain.model.Casella;
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
	
	public void crearPartida(String nomNivell) throws Exception {
		int id = Buscamines.getInstance().getNextIdPartida();//TODO
		System.out.println("IDDDDDDDDD__-------------------------------------->>>>>>>>>>>> " + id);
		CtrlDataFactory ctrlDataFactory = CtrlDataFactory.getInstance();
		Nivell nivell;
		nivell = ctrlDataFactory.getCtrlNivell().getNivell(nomNivell);
		Partida partida = new Partida(id, nivell, currentPlayer);
		currentPartida = partida;
		initTime = System.currentTimeMillis();
	}
	
	
	public class Tresult {
		public boolean acabada;
		public boolean guanyada;
		public long puntuacio;
		public int numero;
		
		public Tresult(boolean guanyada, boolean acabada, long puntuacio, int numero) {
			this.acabada = acabada;
			this.guanyada = guanyada;
			this.puntuacio = puntuacio;
			this.numero = numero;
		}
	}
	
	public Tresult descobrirCasella(int numfila, int numcolumna) throws Exception {
		int id = currentPartida.getIdPartida();
		CtrlCasella ctrlCasella = CtrlDataFactory.getInstance().getCtrlCasella();
		Casella ca = ctrlCasella.getCasella(id, numfila, numcolumna);
		boolean teMina = ca.descobrirCasella();
		currentPartida.incNombreTirades();
		Tresult tresult = new Tresult(false,false,0, ca.getNumero());
		if(teMina) {
			currentPartida.setEstaAcabada(true);
			currentPartida.partidaAcabada();
			tresult.acabada = true;
		}
		else if(currentPartida.totesDescobertes()) {
				currentPartida.setEstaGuanyada(true);
				int puntuacio = currentPartida.getPuntuacio(initTime);
				this.enviaMissatge(id, puntuacio);
				currentPartida.partidaAcabada();
				tresult.guanyada = true;
				tresult.acabada = true;
				tresult.puntuacio = currentPartida.getPuntuacio(initTime);
		}
		return tresult;
	}
	
	public void desmarcarCasella(int numFila, int numColumna) throws Exception {
		CtrlCasella ctrlCasella = CtrlDataFactory.getInstance().getCtrlCasella();
		Casella ca = ctrlCasella.getCasella(currentPartida.getIdPartida(), numFila, numColumna);
		ca.desmarcarCasella();
	}
	
	public void marcarCasella(int numFila, int numColumna) throws Exception {
		CtrlCasella ctrlCasella = CtrlDataFactory.getInstance().getCtrlCasella();
		Casella ca = ctrlCasella.getCasella(currentPartida.getIdPartida(), numFila, numColumna);
		ca.marcarCasella();
	}
	
	public void enviaMissatge(int id, int puntuacio) {
		System.out.println("Partida "+ id + " punts: "+ puntuacio);//TODO
	}

	
	public List<TupleNivells> consultarNivells() throws IOException {
		return new UcConsultarNivells().obtenirNivells();
	}

	public ArrayList<Integer> infoCasella(int i, int j) throws IOException {
		ArrayList<Integer> result = new ArrayList<Integer>(2);
		CtrlCasella ctrlCasella = CtrlDataFactory.getInstance().getCtrlCasella();
		Casella ca = ctrlCasella.getCasella(currentPartida.getIdPartida(), i, j);
		if (ca.getEstaDescoberta()) {
			result.add(0, 1);
			result.add(1, ca.getNumero());
		}
		else result.add(0,0);
		
		return result;
	}
	
	

}
