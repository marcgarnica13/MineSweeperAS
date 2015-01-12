package domain.dataInterface;

import java.io.IOException;

import domain.model.UsuariRegistrat;

public interface CtrlUsuariRegistrat {
	
	public UsuariRegistrat getUsuariRegistrat(String username) throws IOException;

}
