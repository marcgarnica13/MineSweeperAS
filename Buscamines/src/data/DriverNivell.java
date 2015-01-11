package data;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import domain.model.Nivell;

public class DriverNivell {

	public static void main(String[] args) {
		////Aqui és on deu estar el "maxacar" el esquema
		Configuration config = new Configuration();
		config.addAnnotatedClass(Nivell.class);
		config.configure("hibernate.cfg.xml");
		
		//És aquesta la linia on maxaco la bd, suposo que no s'ha de crear sempre, nose
		new SchemaExport(config).create(true,true);

		StandardServiceRegistry sv= new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory(sv);
		Session session = factory.openSession();
		
		////Codi per afegir dos nivells
		
		session.beginTransaction();
		Nivell easy = new Nivell();
		easy.setNom("Easy");
		easy.setNombreCasellesXColumna(5);
		easy.setNombreCasellesXFila(5);
		easy.setNombreMines(5);
		
		session.save(easy);
		
		Nivell normal = new Nivell();
		normal.setNom("Normal");
		normal.setNombreCasellesXColumna(15);
		normal.setNombreCasellesXFila(15);
		normal.setNombreMines(15);
		
		session.save(normal);
		session.getTransaction().commit();
		
		
		////Codi per imprimir els nivells
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("FROM Nivell");
		List list = q.list();
		System.out.println("buuu");
		System.out.println(list);
		System.out.println("buuu");
		t.commit();
		//session.close();
		
	}

}
