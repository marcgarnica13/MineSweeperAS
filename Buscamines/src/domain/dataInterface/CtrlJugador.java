package domain.dataInterface;

import java.io.IOException;

import domain.model.Jugador;

public interface CtrlJugador {
	
	public Jugador getJugador(String username) throws IOException;

}
