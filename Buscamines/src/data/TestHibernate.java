package data;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import domain.model.Nivell;

public class TestHibernate {

	public static void main(String[] args) {
		//showLevels();
		getLevel("Easy");
		
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		/*session.beginTransaction();
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
		Query query = session.createQuery("from Nivell");
        List<?> allNivells = query.list();
        Nivell nivell = (Nivell)allNivells.get(0);
        System.out.println("Level printing:");
        System.out.println(allNivells);
        System.out.println("Level printed");
        HibernateUtil.shutdown();*/

	}

	public static void initiateLevels() {
		Session session = HibernateUtil.getSessionFactory().openSession();
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
		
		Nivell hard = new Nivell();
		hard.setNom("Hard");
		hard.setNombreCasellesXColumna(25);
		hard.setNombreCasellesXFila(25);
		hard.setNombreMines(25);
		
		session.save(hard);
		session.getTransaction().commit();
		
		
	}
	public static void showLevels() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Nivell");
        List<?> allNivells = query.list();
        Nivell nivell = (Nivell)allNivells.get(0);
        System.out.println("Level printing:");
        System.out.println(allNivells);
        System.out.println("Level printed");
        HibernateUtil.shutdown();
	}
	
	public static void getLevel(String nom) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM Nivell N WHERE N.nom = :name");
		query.setParameter("name",nom);
		Nivell nivell = (Nivell) query.uniqueResult();
		System.out.println(nivell.getNom());
		System.out.println(nivell.getNombreMines());
		HibernateUtil.shutdown();
	}

}
