package data;

import org.hibernate.Query;
import org.hibernate.Session;

import domain.dataInterface.CtrlBuscamines;
import domain.model.Buscamines;
import domain.model.Nivell;

public class CtrlBuscaminesBD implements CtrlBuscamines {

	@Override
	public void updateBuscamines(int idnew) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("update Buscamines set idPartida = :new");
		query.setParameter("new", idnew);
		query.executeUpdate();
		session.getTransaction().commit();		
	}

	@Override
	public int getId() {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("SELECT idPartida FROM Buscamines N WHERE N.id = 1");
			int buscaminesId = (int) query.uniqueResult();
			return buscaminesId;
		}

}
