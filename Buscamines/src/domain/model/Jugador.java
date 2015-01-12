package domain.model;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Jugador extends UsuariRegistrat {
	@Basic
	private String email;
	@OneToOne
	private Partida partidaActual = null;
	@OneToMany(targetEntity=Partida.class)
	private Collection<Partida> partidesJugades = null;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void partidaJugada() {
		partidesJugades.add(partidaActual);
		partidaActual = null;
	}
	
}
