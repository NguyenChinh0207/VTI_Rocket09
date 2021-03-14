package com.vti.repository;

import com.vti.entity.Salary;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SalaryRepository {

	private HibernateUtils hibernateUtils;

	public SalaryRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Salary> getAllSalarys() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Salary> query = session.createQuery("FROM Salary");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createSalary(Salary Salary) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(Salary);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
