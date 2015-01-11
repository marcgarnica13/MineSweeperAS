package data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import domain.dataInterface.CtrlNivell;
import domain.model.Nivell;

public class CtrlNivellBD implements CtrlNivell {

	@Override
	public ArrayList<Nivell> getAll() {
		Configuration config = new Configuration();
		config.addAnnotatedClass(Nivell.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true,true);

		StandardServiceRegistry sv= new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory(sv);
		Session session = factory.getCurrentSession();
		
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from NIVELL");
		
		return null;
		
		
	}

	@Override
	public Nivell getNivell(String nom) {
		return null;
	}

}
