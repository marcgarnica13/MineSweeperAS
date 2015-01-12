package domain.dataInterface;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import data.HibernateUtil;
import domain.model.Jugador;
import domain.model.Nivell;

public class CtrlJugadorBD implements CtrlJugador {

	@Override
	public Jugador getJugador(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Jugador N WHERE N.name = :username");
		query.setParameter("username",name);
		Jugador jugador = (Jugador) query.uniqueResult();
		return jugador;
	}

}
