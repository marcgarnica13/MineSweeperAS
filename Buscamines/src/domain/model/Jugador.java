package domain.model;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Jugador extends UsuariRegistrat {
	@Basic
	private String email;
	@ManyToOne
	private Partida partidaActual = null;
	@OneToMany(targetEntity=Partida.class)
	private List<Partida> partidesJugades = null;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	/*
	 * Una vegada la partida esta acabada actualitzem el jugador
	 */
	public void partidaJugada() {
		partidesJugades.add(partidaActual);
		partidaActual = null;
	}
	public void setPartidaActual (Partida p) {
		partidaActual = p;
	}
	
}
