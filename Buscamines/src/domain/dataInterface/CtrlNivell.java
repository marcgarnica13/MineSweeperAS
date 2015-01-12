package domain.dataInterface;

import java.io.IOException;
import java.util.List;

import domain.model.Nivell;

public interface CtrlNivell {
	
	public List<Nivell> getAll() throws IOException;
	public Nivell getNivell(String nom);

}
