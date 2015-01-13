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
		System.out.println(id);
		System.out.println(numF);
		System.out.println(numC);
		query.setParameter("id", id);
		query.setParameter("f", numF);
		query.setParameter("c", numC);
		Casella casella = (Casella) query.uniqueResult();
		if (casella == null) {
			System.out.println("peta");
			throw new IOException("No existeix la casella");
		}
		System.out.println("no peta");
		return casella;

	}

	@Override
	public void saveCasella(Casella casella) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(casella);
		session.getTransaction().commit();		
	}

	@Override
	public void updateCasella(Casella casella) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("update Casella c set c.estaDescoberta = :desc, c.estaMarcada = :marc"+" where idPartida = :idp and numerofila = :f and numerocolumna = :c");
		query.setParameter("desc", casella.getEstaDescoberta());
		query.setParameter("marc", casella.EstaMarcada());
		query.setParameter("idp", casella.getIdPartida());
		query.setParameter("f", casella.getNumeroFila());
		query.setParameter("c", casella.getNumeroColumna());
		query.executeUpdate();
		session.getTransaction().commit();		
	}


}
