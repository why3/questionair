package com.tarena.util;

import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateExport {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Configuration configuration =new Configuration().configure();
			SchemaExport export =new SchemaExport(configuration);
			export.create(true, true);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
