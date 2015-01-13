package gui;

import java.io.IOException;
import java.util.List;

import domain.controllers.UcConsultarNivells.TupleNivells;
import domain.controllers.UcJugarPartida;
import domain.controllers.UcJugarPartida.Tresult;

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

	public void btnStartPressed(TupleNivells nivell) throws Exception {
		ucJugar.crearPartida(nivell.nom);
		new GameView(nivell.nombreCasellesxColumna, nivell.nombreCasellesxFila,this);
	}
	
	public void btnEnterPressed(String username, char[] pwd) throws IOException {
		String password = new String(pwd);
		ucJugar.ferAutenticacio(username, password);
	}

	public Tresult mouseEsquerrePressed(int x, int y) throws Exception {
		return ucJugar.descobrirCasella(x, y);
	}
	

}
