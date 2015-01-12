package data;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import domain.model.Nivell;

public class TestHibernate {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Nivell");
        List<?> allNivells = query.list();
        Nivell nivell = (Nivell)allNivells.get(0);
        System.out.println(nivell);

	}

	public static void showLevels() {
		Configuration config = new Configuration();
		config.addAnnotatedClass(Nivell.class);
		config.configure("hibernate.cfg.xml");
		StandardServiceRegistry sv= new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory factory = config.buildSessionFactory(sv);
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List allNivells;
		System.out.println("Updating all records...");
		Query queryResult = session.createQuery("from Nivell");
		allNivells = queryResult.list();
		System.out.println("# of rows: " + allNivells.size());
		/*for (int i = 0; i < allNivells.size(); i++) {
			User user = (User) allUsers.get(i);
			System.out.println(user);
			user.setPassword("password");
			session.update(user);
		}*/
		System.out.println("Database contents updated...");
		session.getTransaction().commit();
	}

}
