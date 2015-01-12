package domain.controllers;

import java.io.IOException;
import java.util.List;

import domain.controllers.UcConsultarNivells.TupleNivells;

public class UcJugarPartida {
	
	public UcJugarPartida() {
		
	}
	
	public void ferAutenticacio(String username, String pwd) throws IOException {
		new UcLogin().login(username, pwd);
	}
	public List<TupleNivells> consultarNivells() throws IOException {
		return new UcConsultarNivells().obtenirNivells();
	}
	

}
