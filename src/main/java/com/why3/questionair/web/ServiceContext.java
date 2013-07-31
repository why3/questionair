package com.why3.questionair.web;

import java.lang.reflect.Method;

import org.apache.commons.logging.LogFactory;

import zquirrel.util.context.ContextIntercepter;
import zquirrel.util.datasource.HibernateUtil;
import zquirrel.util.datasource.Transaction;

import com.why3.questionair.service.IQuestionSetService;
import com.why3.questionair.service.IUserService;
import com.why3.questionair.service.impl.QuestionSetServiceImpl;
import com.why3.questionair.service.impl.UserServiceImpl;

/**
 * The service context for DAO.
 * 
 * @author plux
 * 
 */
public class ServiceContext extends zquirrel.util.context.ServiceContextSupport {

	// the singleton instance itself.
	private static final ServiceContext CONTEXT = new ServiceContext();

	{
		register(IQuestionSetService.class, QuestionSetServiceImpl.class);
		register(IUserService.class, UserServiceImpl.class);

		addIntercepter(new ContextIntercepter() {

			@Override
			public Object intercept(Object target, Method method,
					Object[] args, TargetChain chain) {
				Transaction transaction = method
						.getAnnotation(Transaction.class);
				if (transaction != null) {
					if (!HibernateUtil.getSession().getTransaction().isActive())
						HibernateUtil.getSession().beginTransaction();
				}

				try {
					Object result = chain.chain(target, method, args);
					
					if (HibernateUtil.getSession().getTransaction().isActive())
						HibernateUtil.getSession().getTransaction().commit();
					return result;
				} catch (Exception ex) {
					LogFactory.getLog(ServiceContext.class).error(ex);
					if (HibernateUtil.getSession().getTransaction().isActive())
						HibernateUtil.getSession().getTransaction().rollback();
					throw new RuntimeException(ex);
				}
			}

		});
	}

	/**
	 * Get an instance of the specific class.
	 * 
	 * @param clazz
	 *            the class of the instance.
	 * @return the instance of the class.
	 */
	public static <T> T get(Class<T> clazz) {
		return CONTEXT.getInstance(clazz);
	}

}
