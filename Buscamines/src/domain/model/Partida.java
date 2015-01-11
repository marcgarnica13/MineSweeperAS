package domain.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Vector;

public class Partida {
	private int idPartida;
	private int nombreTirades;
	private boolean estaAcabada;
	private boolean estaGuanyada;
	private Nivell nivell;
	private ArrayList< ArrayList<Casella> > vcaselles;
	private Jugador jugador;
	private IEstrategiaPuntuacio estrategia;
	
	public Partida(int id, Nivell nivell, Jugador jug) {
		idPartida = id;
		estaAcabada = false;
		estaGuanyada = false;
		nombreTirades = 0;
		this.nivell = nivell;
		jugador = jug;	
	}
	
	public void partidaAcabada() {
		jugador.partidaJugada();
		// ???
	}
	
	public int getIdPartida() {
		return idPartida;
	}
	
	public boolean estaAcabada() {
		return estaAcabada;
	}
	
	public boolean estaGuanyada() {
		return estaGuanyada;
	}
	
	public void setEstaAcabada(boolean estaAcabada) {
		this.estaAcabada = estaAcabada;
	}
	
	public void setEstaGuanyada(boolean estaGuanyada) {
		this.estaGuanyada = estaGuanyada;
	}
	
	public void crearCaselles(int nfiles, int ncols) {
		int fila = 1;
		int col = 1;
		boolean acabat = false;
		ArrayList<Casella> aux = new ArrayList<Casella>();
		while (acabat == false) {
			Casella casella = new Casella(idPartida, fila, col);
			aux.add(casella);
			++col;
			if (col == ncols + 1) {
				col = 1;
				vcaselles.add(aux);
				aux.clear();
				++fila;
				if (fila == nfiles + 1) acabat = true;
			}
		}
	}
	
	public void configurarCaselles(int nmines) {
		while (nmines > 0) {
			Vector<Casella> llcaselles = new Vector<Casella>();
			int fila = (int) (Math.random()*(nivell.getNombreCasellesXColumna()));
			int columna = (int) (Math.random()*(nivell.getNombreCasellesXFila()));
			Casella casella = vcaselles.get(fila).get(columna);
			
			for(int i = -1; i < 2; ++i) {
				for(int j = -1; j < 2; ++j) {
					try {
					Casella aux = vcaselles.get(i+fila).get(j+columna);
					llcaselles.add(aux);
					}
					catch (Exception e) {
					}
				}
			}
			if(casella.posarMina(llcaselles)) {
			--nmines;
			}
		}
	}
	

	public void incNombreTirades() {
		++nombreTirades;
	}
	
	public boolean totesDescobertes() {
		boolean descobert = true;
		for (int i = 0; i < vcaselles.size() && descobert; i++) {
			for (int j = 0; j < vcaselles.get(i).size() && descobert; j++) {
				descobert = vcaselles.get(i).get(j).getEstaDescoberta();
			}
		}
		return descobert;		
	}
	
	public int getPuntuacio(Time initialTime) {
		return estrategia.getPuntuacio(nombreTirades, initialTime);
	}

}
