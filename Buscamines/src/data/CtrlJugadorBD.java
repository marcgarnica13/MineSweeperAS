package data;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import domain.dataInterface.CtrlJugador;
import domain.model.Jugador;
import domain.model.Nivell;

public class CtrlJugadorBD implements CtrlJugador {

	@Override
	public Jugador getJugador(String name) throws IOException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Jugador N WHERE N.username = :n");
		query.setParameter("n",name);
		Jugador jugador = (Jugador) query.uniqueResult();
		if (jugador == null) throw new IOException("No existeix jugador");
		else return jugador;
	}

}
