package gui;

public class JugarPartidaCtrl {
	
	private ViewLogin viewLogin;
	
	public JugarPartidaCtrl() {
		
		//----Aqui hem de crear un controlador del cas d'us
		
		viewLogin = new ViewLogin(this);
		
	}
	
	public void init() {
		viewLogin.setVisible(true);
	}
	
	public void btnPlayPressed() throws Exception {
		//----CRIDA A DOMINI PER OBTENIR NIVELLS
	}

	public void btnStartPressed(String nomNivell) {
		//CRIDA A DOMINI PER INICIAR LA PARTIDA
		new GameView(20,15);
	}
	

}
