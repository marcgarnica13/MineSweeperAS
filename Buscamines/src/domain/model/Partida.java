package domain.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import domain.dataInterface.CtrlDataFactory;

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
	@ManyToOne
	private Nivell nivell;
	@OneToMany(targetEntity=Casella.class)
	private List<ArrayList<Casella>> vcaselles;
	@OneToOne
	private Jugador jugadorPartidaActual;
	@ManyToOne
	private Jugador jugadorPartidaJugada;
	
	//Problemes hibernate mappejant interficies ho canviem per un index 1:temps 2:tirades (Mirar FactoriaEstrategiaPuntuacio)
	@Basic
	private int indexEstrategia;
	
	public Partida(int id, Nivell nivell, Jugador jug) throws Exception {
		idPartida = id;
		estaAcabada = false;
		estaGuanyada = false;
		nombreTirades = 0;
		this.nivell = nivell;
		jugadorPartidaActual = jug;
		vcaselles = new ArrayList<ArrayList<Casella>>();
		
		FactoriaEstrategiaPuntuacio factoriaEstrategiaPuntuacio = FactoriaEstrategiaPuntuacio.getInstance();
		//Obtenim de forma random quina estrategia utilitzem
		indexEstrategia = factoriaEstrategiaPuntuacio.getIndexEstrategiaPuntuacio();
		
		
		jugadorPartidaActual.setPartidaActual(this);
		int nfiles, ncols, nmines;
		nfiles = nivell.getNombreCasellesXColumna();
		ncols = nivell.getNombreCasellesXFila();
		nmines = nivell.getNombreMines();
		crearCaselles(nfiles, ncols);
		configurarCaselles(nmines);
		guardarCaselles();
	}
	
	/*
	 * Guardem la casella a la DB
	 */
	private void guardarCaselles() {
		for (ArrayList<Casella> filacasella : vcaselles) {
			for (Casella casella : filacasella)
				CtrlDataFactory.getInstance().getCtrlCasella().saveCasella(casella);
		}
	}
	

	/*
	 * Actualitzem les associacions amb jugador perque ara sigui el jugadorPartidaJugada i el jugador tambe ho actualitza
	 */
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
	
	public void crearCaselles(int nfiles, int ncols) throws Exception {
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
				aux = new ArrayList<Casella>();
				++fila;
				if (fila == nfiles + 1) acabat = true;
			}
		}
	}
	
	public void configurarCaselles(int nmines) {
		while (nmines > 0) {
			Vector<Casella> llcaselles = new Vector<Casella>();
			int fila = (int)((Math.random()*(nivell.getNombreCasellesXColumna()-1)));
			int columna = (int) (Math.random()*(nivell.getNombreCasellesXFila()-1));
			Casella casella = vcaselles.get(fila).get(columna);
			
			for(int i = -1; i < 2; ++i) {
				for(int j = -1; j < 2; ++j) {
					try {
					Casella aux = vcaselles.get(i+fila).get(j+columna);
					llcaselles.add(aux);
					}
					catch (Exception e) {}
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
	
	/*
	 * Hem d'assegurar que el vector vcaselles esta coherent amb la DB
	 */
	public boolean totesDescobertes() {
		boolean totesDescobertes = true;
		for (ArrayList<Casella> filaCaselles : vcaselles){
			if (totesDescobertes == true) {
			for (Casella c : filaCaselles){
				try {
					Casella casella = CtrlDataFactory.getInstance().getCtrlCasella().getCasella(idPartida, c.getNumeroFila(), c.getNumeroColumna());
					boolean aux = casella.TeMina() || casella.getEstaDescoberta();
					totesDescobertes = totesDescobertes && aux;
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
		}
		return totesDescobertes;
	}
	
	public int getPuntuacio(long initialTime) {
		FactoriaEstrategiaPuntuacio factoriaEstrategiaPuntuacio = FactoriaEstrategiaPuntuacio.getInstance();
		//Amb l'index que tenim obtenim la instancia de la estrategia de puntuacio
		IEstrategiaPuntuacio estrategia = factoriaEstrategiaPuntuacio.getEstrategiaPuntuacio(indexEstrategia);
		return (int) estrategia.getPuntuacio(nombreTirades, initialTime);
	}

}
