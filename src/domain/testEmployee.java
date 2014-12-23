package domain;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class testEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration conf = new AnnotationConfiguration();
		conf.addAnnotatedClass(Employee.class);
		conf.configure("hibernate.cfg.xml");
		new SchemaExport(conf).create(true, true);
	}

}
