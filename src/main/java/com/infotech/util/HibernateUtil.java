package com.infotech.util;


import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateUtil {

	private static StandardServiceRegistry standardServiceRegistry;
	
	private static SessionFactory sessionFactory;
	
	static {
		

		StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
		
		Map<String, String> dbsettings = new HashMap<>();
		dbsettings.put(Environment.URL,"jdbc:mysql://localhost:3306/hibdb");
		dbsettings.put(Environment.USER,"root");
		dbsettings.put(Environment.PASS,"Muthu");
		dbsettings.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
		dbsettings.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
		dbsettings.put(Environment.SHOW_SQL,"true");
		dbsettings.put(Environment.HBM2DDL_AUTO,"update");
		
		
		registryBuilder.applySettings(dbsettings);
		
		standardServiceRegistry = registryBuilder.build();
		
		MetadataSources sources = new MetadataSources(standardServiceRegistry);
		
		Metadata metadata = sources.getMetadataBuilder().build();
		
		sessionFactory = metadata.getSessionFactoryBuilder().build();
		
	
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
