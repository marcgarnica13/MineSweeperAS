package domain.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import domain.dataInterface.CtrlDataFactory;

@Entity
public class Buscamines {
		@Id
		@GeneratedValue
		private long id;
		private static Buscamines instance = null;
		@Basic
		private int idPartida;
		
		protected Buscamines() {
			idPartida = (int) (Math.random()*1000);
		}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public int getIdPartida() {
			return idPartida;
		}
		public void setIdPartida(int idPartida) {
			this.idPartida = idPartida;
		}
		public static Buscamines getInstance() {
			if (instance == null) instance = new Buscamines();
			return instance;
		}
		
		public int getNextIdPartida() {
			++idPartida;
			CtrlDataFactory.getInstance().getCtrlBuscamines().updateBuscamines(idPartida);
			return idPartida;
		}
	}
