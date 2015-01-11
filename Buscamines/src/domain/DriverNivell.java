package domain;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class DriverNivell {

	public static void main(String[] args) {
		Configuration config = new Configuration();
		config.addAnnotatedClass(Nivell.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true,true);

		StandardServiceRegistry sv= new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory(sv);
		Session session = factory.getCurrentSession();
		
		session.beginTransaction();
		
		Nivell normal = new Nivell();
		normal.setNom("Normal");
		normal.setNombreCasellesXColumna(15);
		normal.setNombreCasellesXFila(15);
		normal.setNombreMines(15);
		
		session.save(normal);
		session.getTransaction().commit();

	}

}
