package domain.model;

import data.CtrlNivellBD;
import data.CtrlUsuariRegistratBD;
import domain.dataInterface.CtrlDataFactory;
import domain.dataInterface.CtrlNivell;
import domain.dataInterface.CtrlUsuariRegistrat;

public class Buscamines {
		private static Buscamines instance = null;
		private int idPartida;
		
		protected Buscamines() {
			idPartida = 0;
		}
		public static Buscamines getInstance() {
			if (instance == null) instance = new Buscamines();
			return instance;
		}
		
		public int getNextIdPartida() {
			++idPartida;
			return idPartida;
		}
	}
