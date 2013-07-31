package zquirrel.util.datasource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Utilities to use Hibernate more easily.
 * 
 * @author plux
 * 
 */
public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> localSession;

	static {
		Configuration configuration = new Configuration()
				.configure("hibernate/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		localSession = new ThreadLocal<Session>();
	}

	private HibernateUtil() {
	}

	/**
	 * Get or create a hibernate session in local thread.
	 * 
	 * @return the session.
	 */
	public static Session getSession() {
		Session session = localSession.get();
		if (session == null) {
			session = sessionFactory.openSession();
			localSession.set(session);
		}
		return session;
	}

	/**
	 * Close the session in local thread.
	 */
	public static void closeSession() {
		Session session = localSession.get();
		if (session != null && session.isOpen()) {
			session.close();
			localSession.set(null);
		}
	}

}
