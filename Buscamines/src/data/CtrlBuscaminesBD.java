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

	@Override
	public int getIdPartida() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("select idPartida from Buscamines");
		int idPartida = (int) query.list().get(0);
		System.out.println(idPartida);
		return idPartida;
	}

}
