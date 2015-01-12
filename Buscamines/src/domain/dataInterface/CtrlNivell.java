package domain.dataInterface;

import java.util.List;

import domain.model.Nivell;

public interface CtrlNivell {
	
	public List<Nivell> getAll();
	public Nivell getNivell(String nom);

}
