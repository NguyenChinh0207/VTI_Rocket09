package com.vti.repository;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Department;
import com.vti.entity.User;
import com.vti.utils.HibernateUtils;
@Repository
public class UserRepository implements IUserRepository {

	private HibernateUtils hibernateUtils;

	public UserRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	@Override
	public User getUserByName(String username) {
		// TODO Auto-generated method stub
		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<User> query = session.createQuery("FROM User WHERE username = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", username);

			// get result
			User user = query.uniqueResult();

			return user;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
