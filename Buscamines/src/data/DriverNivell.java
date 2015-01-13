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

import domain.model.IEstrategiaPuntuacio;
import domain.model.Jugador;
import domain.model.Nivell;
import domain.model.Partida;
import domain.model.TempsEstrategiaPuntuacio;
import domain.model.TiradesEstrategiaPuntuacio;
import domain.model.UsuariRegistrat;

public class DriverNivell {

	public static void main(String[] args) {
		////Aqui és on deu estar el "maxacar" el esquema
		Configuration config = new Configuration();
		config.addAnnotatedClass(Jugador.class);
		config.addAnnotatedClass(Partida.class);//pol
		config.addAnnotatedClass(TempsEstrategiaPuntuacio.class);
		config.addAnnotatedClass(TiradesEstrategiaPuntuacio.class);
		config.configure("hibernate.cfg.xml");
		
		//És aquesta la linia on maxaco la bd, suposo que no s'ha de crear sempre, nose
		
		new SchemaExport(config).create(true,true);

		StandardServiceRegistry sv= new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory(sv);
		Session session = factory.openSession();
		
		session.beginTransaction();
		Jugador marc = new Jugador();
		marc.setNom("Marc");
		marc.setCognom("Garnica");
		marc.setUsername("marc");
		marc.setPwd("cram");
		marc.setEmail("marcgarnica@gmail.com");
		
		session.save(marc);
		session.getTransaction().commit();
		session.close();
		
		////Codi per afegir dos nivells
		/*
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
		System.out.println("pololo");
		Transaction t = session.beginTransaction();
		System.out.println("pololo2");
		Query q = session.createQuery("FROM Nivell");
		System.out.println("pololo despre de la query");
		List list = q.list();
		System.out.println("buuu");
		System.out.println(list);
		System.out.println("buuu");
		t.commit();
		session.close();*/
		
	}

}
