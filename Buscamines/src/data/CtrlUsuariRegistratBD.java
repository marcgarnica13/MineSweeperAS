package data;

import java.io.IOException;

import org.hibernate.Query;
import org.hibernate.Session;

import domain.dataInterface.CtrlUsuariRegistrat;
import domain.model.UsuariRegistrat;

public class CtrlUsuariRegistratBD implements CtrlUsuariRegistrat {

	@Override
	public UsuariRegistrat getUsuariRegistrat(String username)
			throws IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM UsuariRegistrat u WHERE u.username = :name");
		query.setParameter("name",username);
		UsuariRegistrat usuari = (UsuariRegistrat) query.uniqueResult();
		if (usuari == null) throw new IOException("Usuari no existeix");
		else return usuari;
	}

}
