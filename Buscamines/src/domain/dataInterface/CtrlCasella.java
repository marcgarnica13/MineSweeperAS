package domain.dataInterface;

import java.io.IOException;

import domain.model.Casella;

public interface CtrlCasella {
	
	public Casella getCasella(int id, int numF, int numC) throws IOException;
	
}