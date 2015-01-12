package data;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import domain.dataInterface.CtrlNivell;
import domain.model.Nivell;

public class CtrlNivellBD implements CtrlNivell {

	@Override
	public List<Nivell> getAll() throws IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Nivell");
        List<Nivell> allNivells = query.list();
        HibernateUtil.shutdown();
        if (allNivells.size() == 0) throw new IOException("No hi ha nivells");
        else return allNivells;
	}

	@Override
	public Nivell getNivell(String nom) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Nivell N WHERE N.nom = :name");
		query.setParameter("name",nom);
		Nivell nivell = (Nivell) query.uniqueResult();
		return nivell;
	}

}
