package data;

import org.hibernate.Query;
import org.hibernate.Session;

import domain.dataInterface.CtrlBuscamines;

public class CtrlBuscaminesBD implements CtrlBuscamines {

	@Override
	public void updateBuscamines(int idnew) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("update Buscamines set idPartida = :new");
		query.setParameter("new", idnew);
		query.executeUpdate();
		session.getTransaction().commit();		
	}

}
