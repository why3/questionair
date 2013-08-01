package zquirrel.util.datasource;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import zquirrel.util.context.ContextRef;

public class CHibDao<T extends Serializable> implements HibDao<T> {

	// the log.
	private final static Log log = LogFactory.getLog(CHibDao.class);

	// the hibernate session.
	@ContextRef
	private Session session;

	/**
	 * The entity class.
	 */
	private Class<T> clazz;

	/**
	 * Construct a new HibernateDao object of specific entity class.
	 * 
	 * @param clazz
	 *            the entity class.
	 */
	public CHibDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * zquirrel.util.datasource.HibDao#find(org.hibernate.criterion.Criterion)
	 */
	@Override
	public T find(Criterion restriction) {
		// Session session = getSession();
		T obj = null;
		LogFactory.getLog(CHibDao.class).warn("Session: " + session);
		Criteria query = session.createCriteria(clazz);
		query.add(restriction);
		obj = clazz.cast(query.uniqueResult());
		return obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zquirrel.util.datasource.HibDao#find(java.io.Serializable)
	 */
	@Override
	public T find(Serializable id) {
		Session session = getSession();
		T obj = null;
		obj = clazz.cast(session.get(clazz, id));
		return obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * zquirrel.util.datasource.HibDao#list(org.hibernate.criterion.Criterion)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> list(Criterion criterion) {
		Session session = getSession();
		List<T> emps = null;
		Criteria query = session.createCriteria(clazz);
		query.add(criterion);
		emps = query.list();
		return emps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * zquirrel.util.datasource.HibDao#list(org.hibernate.criterion.Criterion,
	 * int, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> list(Criterion criterion, int start, int length) {
		Session session = getSession();
		List<T> emps = null;
		Criteria query = session.createCriteria(clazz);
		query.add(criterion);
		query.setFirstResult(start);
		query.setMaxResults(length);
		emps = query.list();
		return emps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zquirrel.util.datasource.HibDao#listAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> listAll() {
		Session session = getSession();
		List<T> emps = null;
		Criteria query = session.createCriteria(clazz);
		emps = query.list();
		return emps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zquirrel.util.datasource.HibDao#list(int, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> list(int start, int length) {
		Session session = getSession();
		List<T> emps = null;
		Criteria query = session.createCriteria(clazz);
		query.setFirstResult(start);
		query.setMaxResults(length);

		log.debug("start: " + start + "; length: " + length);

		emps = query.list();
		return emps;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zquirrel.util.datasource.HibDao#save(T)
	 */
	@Override
	public Object save(T object) {
		Session session = getSession();
		Object id = session.save(object);
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zquirrel.util.datasource.HibDao#update(T)
	 */
	@Override
	public int update(T object) {
		getSession().update(object);
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zquirrel.util.datasource.HibDao#delete(T)
	 */
	@Override
	public int delete(T obj) {
		getSession().delete(obj);
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see zquirrel.util.datasource.HibDao#count()
	 */
	@Override
	public int count() {
		int count = -1;
		Session session = getSession();
		Criteria query = session.createCriteria(clazz);
		query.setProjection(Projections.rowCount());
		count = (Integer) query.uniqueResult();
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * zquirrel.util.datasource.HibDao#count(org.hibernate.criterion.Criterion)
	 */
	@Override
	public int count(Criterion restrictions) {
		int count = 0;
		Criteria query = session.createCriteria(clazz);
		query.setProjection(Projections.rowCount()).add(restrictions);
		count = (Integer) query.uniqueResult();
		return count;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(Criterion criterion, Order order, int start, int length) {
		return getSession().createCriteria(clazz).add(criterion)
				.addOrder(order).setFirstResult(start).setMaxResults(length)
				.list();
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Session getSession() {
		return this.session;
	}

}
