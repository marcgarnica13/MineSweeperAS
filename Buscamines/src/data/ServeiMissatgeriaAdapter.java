package data;

import domain.adapters.IserveiMissatgeriaAdapter;
import domain.adapters.ServeiMissatgeria;
import domain.adapters.ServicesLocator;

public class ServeiMissatgeriaAdapter implements IserveiMissatgeriaAdapter{

	@Override
	public void enviarMissatge(int id, int puntuacio) {
        String missatge = "ID Jugador: " + Integer.toString(id) + "  " + "Puntuacio: " + Integer.toString(puntuacio);
        
        ServeiMissatgeria sm = ServicesLocator.getInstance().getServeiMissatgeria();
        sm.enviarMissatge(missatge);
        
	}
	
	

}
