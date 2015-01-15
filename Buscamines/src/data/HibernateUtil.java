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

/*
 * Classe que reuneix les funcions de configuracio del Hibernate per obrir la sessio. Es necessaria la seva crida en cada us de la DB.
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration config  = new Configuration();
			config.addAnnotatedClass(UsuariRegistrat.class);
			config.addAnnotatedClass(Jugador.class);
			config.addAnnotatedClass(Partida.class);
			config.addAnnotatedClass(Nivell.class);
			config.addAnnotatedClass(Casella.class);
			config.addAnnotatedClass(Buscamines.class);
			config.addAnnotatedClass(TempsEstrategiaPuntuacio.class);
			config.addAnnotatedClass(TiradesEstrategiaPuntuacio.class);
			config.configure("hibernate.cfg.xml");
			
			//Cal descomentar aquesta linea el primer cop per a tal de crear la DB.
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
