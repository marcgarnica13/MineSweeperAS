package domain.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Partida {
	@Id
	private int idPartida;
	@Basic
	private int nombreTirades;
	@Basic
	private boolean estaAcabada;
	@Basic
	private boolean estaGuanyada;
	@OneToMany
	private Nivell nivell;
	@OneToMany
	private Collection<Collection<Casella>> vcaselles;
	@OneToOne
	private Jugador jugadorPartidaActual;
	@ManyToOne
	private Jugador jugadorPartidaJugada;
	@ManyToOne
	private IEstrategiaPuntuacio estrategia;
	
	public Partida(int id, Nivell nivell, Jugador jug) {
		idPartida = id;
		estaAcabada = false;
		estaGuanyada = false;
		nombreTirades = 0;
		this.nivell = nivell;
		jugadorPartidaActual = jug;
		
		//strategy := getEstrategiaPuntuacio() de :FactoriaEstrategiaPuntuacio
		
		jugadorPartidaActual.setPartidaActual(this);
		int nfiles, ncols, nmines;
		nfiles = nivell.getNombreCasellesXColumna();
		ncols = nivell.getNombreCasellesXFila();
		nmines = nivell.getNombreMines();
		crearCaselles(nfiles, ncols);
		configurarCaselles(nmines);	
	}
	
	public void partidaAcabada() {
		jugadorPartidaActual.partidaJugada();
		jugadorPartidaJugada = jugadorPartidaActual;
		jugadorPartidaActual = null;
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
	
	public int getPuntuacio(long initialTime) {
		return (int) estrategia.getPuntuacio(nombreTirades, initialTime);
	}

}
