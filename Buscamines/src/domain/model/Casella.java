package domain.model;

import java.io.Serializable;
import java.util.Vector;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import domain.dataInterface.CtrlCasella;
import domain.dataInterface.CtrlDataFactory;

@Entity
public class Casella implements Serializable {
	@Id
	private int idPartida;
	@Id
	private int numeroFila;
	@Id
	private int numeroColumna;
	@Basic
	private int numero;
	@Basic
	private boolean estaDescoberta;
	@Basic
	private boolean estaMarcada;
	@Basic
	private boolean teMina;
	
	
	public Casella() {
		idPartida = 0;
		numeroFila = 0;
		numeroColumna = 0;
		numero = 0;
		estaDescoberta = false;
		estaMarcada = false;
		teMina = false;
	}
	
	public Casella(int idPartida, int fila, int columna) {
		this.idPartida = idPartida;
		numero = 0;
		numeroFila = fila;
		numeroColumna = columna;
		estaDescoberta = false;
		estaMarcada = false;
		teMina = false;
	}
	
	/**
	 * @return the numeroFila
	 */
	public int getNumeroFila() {
		return numeroFila;
	}
	
	/**
	 * @param numeroFila the numeroFila to set
	 */
	public void setNumeroFila(int numeroFila) {
		this.numeroFila = numeroFila;
	}
	
	/**
	 * @return the numeroColumna
	 */
	public int getNumeroColumna() {
		return numeroColumna;
	}
	
	/**
	 * @param numeroColumna the numeroColumna to set
	 */
	public void setNumeroColumna(int numeroColumna) {
		this.numeroColumna = numeroColumna;
	}
	
	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
	
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/**
	 * @return the estaDescoberta
	 */
	public boolean getEstaDescoberta() {
		return estaDescoberta;
	}
	
	/**
	 * @param estaDescoberta the estaDescoberta to set
	 */
	public void setEstaDescoberta(boolean estaDescoberta) {
		this.estaDescoberta = estaDescoberta;
	}
	
	/**
	 * @return the estaMarcada
	 */
	public boolean EstaMarcada() {
		return estaMarcada;
	}
	
	/**
	 * @param estaMarcada the estaMarcada to set
	 */
	public void setEstaMarcada(boolean estaMarcada) {
		this.estaMarcada = estaMarcada;
	}
	
	/**
	 * @return the teMina
	 */
	public boolean TeMina() {
		return teMina;
	}
	
	/**
	 * @param teMina the teMina to set
	 */
	public void setTeMina(boolean teMina) {
		this.teMina = teMina;
	}
	
	/**
	 * incrementa parametre numero
	 */
	public void incrementaNum() {
		if (teMina == false) numero = numero + 1;
	}
	
	/**
	 * DescobrirCasella
	 * @throws Exception casellaJaDescoberta
	 * @throws Exception casellaJaMarcada
	 */
	public boolean descobrirCasella() throws Exception {
		if (estaDescoberta == true) throw new Exception("casellaJaDescoberta");
		else if (estaMarcada == true) throw new Exception ("casellaJaMarcada");
		estaDescoberta = true;
		if ((teMina == false) && (numero == 0)) {
			Vector<Casella> veines = new Vector<Casella>(8);
			CtrlDataFactory ctrlDataFactory = CtrlDataFactory.getInstance();
			CtrlCasella contCasella = ctrlDataFactory.getCtrlCasella();
			
			//cridar el controlador data factory get casella
			veines.add(contCasella.getCasella(idPartida, numeroFila-1, numeroColumna-1));
			veines.add(contCasella.getCasella(idPartida, numeroFila-1, numeroColumna));
			veines.add(contCasella.getCasella(idPartida, numeroFila-1, numeroColumna+1));
			veines.add(contCasella.getCasella(idPartida, numeroFila, numeroColumna-1));
			veines.add(contCasella.getCasella(idPartida, numeroFila, numeroColumna+1));
			veines.add(contCasella.getCasella(idPartida, numeroFila+1, numeroColumna-1));
			veines.add(contCasella.getCasella(idPartida, numeroFila+1, numeroColumna));
			veines.add(contCasella.getCasella(idPartida, numeroFila+1, numeroColumna+1));
			
			for (int i = 0; i < veines.size(); i++) veines.get(i).descobrirCasella();	
		}
		return teMina;
	}
	
	public boolean posarMina(Vector<Casella> llcaselles) {
		numero = 0;
		if (teMina == false) {
			teMina = true;
			for (int i = 0; i < llcaselles.size(); i++) llcaselles.get(i).incrementaNum();
			return true;
		}
		else return false;
	}
	
	/**
	 * MarcarCasella
	 * @throws Exception 
	 */
	public void marcarCasella() throws Exception {
		if (estaMarcada == true) throw new Exception("casellaJaMarcada");
		else if (estaDescoberta == false) throw new Exception("casellaJaDescoberta");
		estaMarcada = true;
	}
	
	/**
	 * DesmarcarCasella
	 * @throws Exception 
	 */
	public void desmarcarCasella() throws Exception {
		if (estaMarcada == false) throw new Exception("casellaNoMarcada");
		else if (estaDescoberta == false) throw new Exception("casellaJaDescoberta");
		estaMarcada = false;
	}
}
