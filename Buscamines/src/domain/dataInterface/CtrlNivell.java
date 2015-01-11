package domain.dataInterface;

import java.util.ArrayList;

import domain.model.Nivell;

public interface CtrlNivell {
	
	public ArrayList<Nivell> getAll();
	public Nivell getNivell(String nom);

}
