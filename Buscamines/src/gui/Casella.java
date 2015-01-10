package gui;

public class Casella {
	private int numeroFila;
	private int numeroColumna;
	private int numero;
	private boolean estaDescoberta;
	private boolean estaMarcada;
	private boolean teMina;
	
	
	public Casella() {
		numeroFila = null;
		numeroColumna = null;
		numero = null;
		estaDescoberta = false;
		estaMarcada = false;
		teMina = false;
	}
	
	public Casella(int fila, int columna) {
		numero = null;
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
	public boolean isEstaMarcada() {
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
	public boolean isTeMina() {
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
		numero = numero + 1;
	}
	
	/**
	 * DescobrirCasella
	 * @return
	 */
	public boolean descobrirCasella() {
		if (estaDescoberta == true) throw new Exception("casellaJaDescoberta");
		else if (estaMarcada == true) throw new Exception ("casellaJaMarcada");
		else if ()
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
