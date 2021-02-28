package com.vti.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class TestHibernate {
	public static void main(String[] args) {

		// get session
		Session session = null;
		try {
			session = buildSessionFactory().openSession();
			session.beginTransaction();

			TestingCategory category = new TestingCategory();
			Group group1=new Group();
			Query<Group> query = session.createQuery("FROM Group");
			List<Group> groupList=query.list();
			for (Group group: groupList) {
				System.out.println(group);
			}

			System.out.println("Create success!");

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	private static SessionFactory buildSessionFactory() {
		// load configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity
		configuration.addAnnotatedClass(Group.class);
		configuration.addAnnotatedClass(User.class);
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();

		return configuration.buildSessionFactory(serviceRegistry);
	}
}
