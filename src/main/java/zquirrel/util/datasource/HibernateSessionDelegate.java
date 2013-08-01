package zquirrel.util.datasource;

import java.io.Serializable;
import java.sql.Connection;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.EntityMode;
import org.hibernate.Filter;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.ReplicationMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.hibernate.stat.SessionStatistics;

public class HibernateSessionDelegate implements Session {
	private static final long serialVersionUID = 20130701L;

	private Session getSession() {
		return HibernateUtil.getSession();
	}

	public Transaction beginTransaction() throws HibernateException {
		return getSession().beginTransaction();
	}

	public void cancelQuery() throws HibernateException {
		getSession().cancelQuery();
	}

	public void clear() {
		getSession().clear();
	}

	public Connection close() throws HibernateException {
		return getSession().close();
	}

	@Deprecated
	public Connection connection() throws HibernateException {
		return getSession().connection();
	}

	public boolean contains(Object arg0) {
		return getSession().contains(arg0);
	}

	@SuppressWarnings("rawtypes")
	public Criteria createCriteria(Class arg0, String arg1) {
		return getSession().createCriteria(arg0, arg1);
	}

	@SuppressWarnings("rawtypes")
	public Criteria createCriteria(Class arg0) {
		return getSession().createCriteria(arg0);
	}

	public Criteria createCriteria(String arg0, String arg1) {
		return getSession().createCriteria(arg0, arg1);
	}

	public Criteria createCriteria(String arg0) {
		return getSession().createCriteria(arg0);
	}

	public Query createFilter(Object arg0, String arg1)
			throws HibernateException {
		return getSession().createFilter(arg0, arg1);
	}

	public Query createQuery(String arg0) throws HibernateException {
		return getSession().createQuery(arg0);
	}

	public SQLQuery createSQLQuery(String arg0) throws HibernateException {
		return getSession().createSQLQuery(arg0);
	}

	public void delete(Object arg0) throws HibernateException {
		getSession().delete(arg0);
	}

	public void delete(String arg0, Object arg1) throws HibernateException {
		getSession().delete(arg0, arg1);
	}

	public void disableFilter(String arg0) {
		getSession().disableFilter(arg0);
	}

	public Connection disconnect() throws HibernateException {
		return getSession().disconnect();
	}

	public void doWork(Work arg0) throws HibernateException {
		getSession().doWork(arg0);
	}

	public Filter enableFilter(String arg0) {
		return getSession().enableFilter(arg0);
	}

	public void evict(Object arg0) throws HibernateException {
		getSession().evict(arg0);
	}

	public void flush() throws HibernateException {
		getSession().flush();
	}

	@SuppressWarnings("rawtypes")
	public Object get(Class arg0, Serializable arg1, LockMode arg2)
			throws HibernateException {
		return getSession().get(arg0, arg1, arg2);
	}

	@SuppressWarnings("rawtypes")
	public Object get(Class arg0, Serializable arg1) throws HibernateException {
		return getSession().get(arg0, arg1);
	}

	public Object get(String arg0, Serializable arg1, LockMode arg2)
			throws HibernateException {
		return getSession().get(arg0, arg1, arg2);
	}

	public Object get(String arg0, Serializable arg1) throws HibernateException {
		return getSession().get(arg0, arg1);
	}

	public CacheMode getCacheMode() {
		return getSession().getCacheMode();
	}

	public LockMode getCurrentLockMode(Object arg0) throws HibernateException {
		return getSession().getCurrentLockMode(arg0);
	}

	public Filter getEnabledFilter(String arg0) {
		return getSession().getEnabledFilter(arg0);
	}

	public EntityMode getEntityMode() {
		return getSession().getEntityMode();
	}

	public String getEntityName(Object arg0) throws HibernateException {
		return getSession().getEntityName(arg0);
	}

	public FlushMode getFlushMode() {
		return getSession().getFlushMode();
	}

	public Serializable getIdentifier(Object arg0) throws HibernateException {
		return getSession().getIdentifier(arg0);
	}

	public Query getNamedQuery(String arg0) throws HibernateException {
		return getSession().getNamedQuery(arg0);
	}

	public Session getSession(EntityMode arg0) {
		return getSession().getSession(arg0);
	}

	public SessionFactory getSessionFactory() {
		return getSession().getSessionFactory();
	}

	public SessionStatistics getStatistics() {
		return getSession().getStatistics();
	}

	public Transaction getTransaction() {
		return getSession().getTransaction();
	}

	public boolean isConnected() {
		return getSession().isConnected();
	}

	public boolean isDirty() throws HibernateException {
		return getSession().isDirty();
	}

	public boolean isOpen() {
		return getSession().isOpen();
	}

	@SuppressWarnings("rawtypes")
	public Object load(Class arg0, Serializable arg1, LockMode arg2)
			throws HibernateException {
		return getSession().load(arg0, arg1, arg2);
	}

	@SuppressWarnings("rawtypes")
	public Object load(Class arg0, Serializable arg1) throws HibernateException {
		return getSession().load(arg0, arg1);
	}

	public void load(Object arg0, Serializable arg1) throws HibernateException {
		getSession().load(arg0, arg1);
	}

	public Object load(String arg0, Serializable arg1, LockMode arg2)
			throws HibernateException {
		return getSession().load(arg0, arg1, arg2);
	}

	public Object load(String arg0, Serializable arg1)
			throws HibernateException {
		return getSession().load(arg0, arg1);
	}

	public void lock(Object arg0, LockMode arg1) throws HibernateException {
		getSession().lock(arg0, arg1);
	}

	public void lock(String arg0, Object arg1, LockMode arg2)
			throws HibernateException {
		getSession().lock(arg0, arg1, arg2);
	}

	public Object merge(Object arg0) throws HibernateException {
		return getSession().merge(arg0);
	}

	public Object merge(String arg0, Object arg1) throws HibernateException {
		return getSession().merge(arg0, arg1);
	}

	public void persist(Object arg0) throws HibernateException {
		getSession().persist(arg0);
	}

	public void persist(String arg0, Object arg1) throws HibernateException {
		getSession().persist(arg0, arg1);
	}

	@Deprecated
	public void reconnect() throws HibernateException {
		getSession().reconnect();
	}

	public void reconnect(Connection arg0) throws HibernateException {
		getSession().reconnect(arg0);
	}

	public void refresh(Object arg0, LockMode arg1) throws HibernateException {
		getSession().refresh(arg0, arg1);
	}

	public void refresh(Object arg0) throws HibernateException {
		getSession().refresh(arg0);
	}

	public void replicate(Object arg0, ReplicationMode arg1)
			throws HibernateException {
		getSession().replicate(arg0, arg1);
	}

	public void replicate(String arg0, Object arg1, ReplicationMode arg2)
			throws HibernateException {
		getSession().replicate(arg0, arg1, arg2);
	}

	public Serializable save(Object arg0) throws HibernateException {
		return getSession().save(arg0);
	}

	public Serializable save(String arg0, Object arg1)
			throws HibernateException {
		return getSession().save(arg0, arg1);
	}

	public void saveOrUpdate(Object arg0) throws HibernateException {
		getSession().saveOrUpdate(arg0);
	}

	public void saveOrUpdate(String arg0, Object arg1)
			throws HibernateException {
		getSession().saveOrUpdate(arg0, arg1);
	}

	public void setCacheMode(CacheMode arg0) {
		getSession().setCacheMode(arg0);
	}

	public void setFlushMode(FlushMode arg0) {
		getSession().setFlushMode(arg0);
	}

	public void setReadOnly(Object arg0, boolean arg1) {
		getSession().setReadOnly(arg0, arg1);
	}

	public void update(Object arg0) throws HibernateException {
		getSession().update(arg0);
	}

	public void update(String arg0, Object arg1) throws HibernateException {
		getSession().update(arg0, arg1);
	}
}
