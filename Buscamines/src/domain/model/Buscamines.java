package domain.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import data.CtrlNivellBD;
import data.CtrlUsuariRegistratBD;
import domain.dataInterface.CtrlDataFactory;
import domain.dataInterface.CtrlNivell;
import domain.dataInterface.CtrlUsuariRegistrat;

@Entity
public class Buscamines {
		@Id
		@GeneratedValue
		private long id;
		private static Buscamines instance = null;
		@Basic
		private int idPartida;
		
		protected Buscamines() {
			idPartida = 0;
		}
		public static Buscamines getInstance() {
			if (instance == null) instance = new Buscamines();
			return instance;
		}
		
		public int getNextIdPartida() {
			System.out.println(idPartida);
			++idPartida;
			CtrlDataFactory.getInstance().getCtrlBuscamines().updateBuscamines(idPartida);
			return idPartida;
		}
		public int getIdPartida() {
			return idPartida;
		}
	}
