package gui;

import java.io.IOException;
import java.util.List;

import domain.controllers.UcConsultarNivells.TupleNivells;
import domain.controllers.UcJugarPartida;

public class JugarPartidaCtrl {
	
	private ViewLogin viewLogin;
	private UcJugarPartida ucJugar;
	
	public JugarPartidaCtrl() {
		
		ucJugar = new UcJugarPartida();
		viewLogin = new ViewLogin(this);
		
	}
	
	public void init() {
		viewLogin.setVisible(true);
	}
	
	public List<TupleNivells> btnPlayPressed() throws IOException {
		return ucJugar.consultarNivells();
	}

	public void btnStartPressed(String nomNivell) {
		//CRIDA A DOMINI PER INICIAR LA PARTIDA
		new GameView(20,15);
	}
	
	public void btnEnterPressed(String username, char[] pwd) throws IOException {
		String password = new String(pwd);
		ucJugar.ferAutenticacio(username, password);
	}
	

}
