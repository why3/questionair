package zquirrel.util.datasource;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * Hibernate Export class.
 * 
 * @author plux
 * 
 */
public class HibernateExport {

	/**
	 * Export the schema to the database.
	 * 
	 * @param args
	 *            the arguments.
	 */
	public static void main(String[] args) {
		new SchemaExport(
				new Configuration().configure("hibernate/hibernate.cfg.xml"))
				.create(true, true);
	}

}
