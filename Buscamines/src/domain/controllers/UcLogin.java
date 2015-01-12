package domain.controllers;

import java.io.IOException;

import domain.dataInterface.CtrlDataFactory;
import domain.model.UsuariRegistrat;

public class UcLogin {
	
	public void login(String username, String pwd) throws IOException {
		CtrlDataFactory ctrlDataFactory = CtrlDataFactory.getInstance();
		UsuariRegistrat user;
		try {
			user = ctrlDataFactory.getCtrlUsuariRegistrat().getUsuariRegistrat(username);
		} catch (IOException e) {
			throw e;
		}
		System.out.println(pwd + " " + user.getPwd());
		if (!pwd.equals(user.getPwd())) throw new IOException("Password incorrecte");
	}

}
