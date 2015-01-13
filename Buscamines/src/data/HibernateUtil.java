package data;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import domain.model.Buscamines;
import domain.model.Casella;
import domain.model.Jugador;
import domain.model.Nivell;
import domain.model.Partida;
import domain.model.TempsEstrategiaPuntuacio;
import domain.model.TiradesEstrategiaPuntuacio;
import domain.model.UsuariRegistrat;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Use hibernate.cfg.xml to get a SessionFactory
			Configuration config  = new Configuration();
			config.addAnnotatedClass(UsuariRegistrat.class);
			config.addAnnotatedClass(Jugador.class);
			config.addAnnotatedClass(Partida.class);//pol
			config.addAnnotatedClass(Nivell.class);
			config.addAnnotatedClass(Casella.class);
			config.addAnnotatedClass(Buscamines.class);
			config.addAnnotatedClass(TempsEstrategiaPuntuacio.class);
			config.addAnnotatedClass(TiradesEstrategiaPuntuacio.class);
			config.configure("hibernate.cfg.xml");
			//new SchemaExport(config).create(true,true);
			StandardServiceRegistry sv= new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			return config.buildSessionFactory(sv);
		} catch (Throwable ex) {
			System.err.println("SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}
