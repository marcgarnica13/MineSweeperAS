package data;

import java.io.IOException;

import org.hibernate.Query;
import org.hibernate.Session;

import domain.dataInterface.CtrlCasella;
import domain.model.Casella;
import domain.model.Nivell;

public class CtrlCasellaBD implements CtrlCasella {
	
	@Override
	public Casella getCasella(int id, int numF, int numC) throws IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Casella c WHERE c.idPartida = :id and c.numeroFila = :f and c.numeroColumna = :c");
		
		query.setParameter("id", id);
		query.setParameter("f", numC);
		query.setParameter("c", numF);
		Casella casella = (Casella) query.uniqueResult();
		if (casella == null) throw new IOException("No existeix la casella");
		return casella;

	}

	@Override
	public void saveCasella(Casella casella) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(casella);
		session.getTransaction().commit();		
	}


}
