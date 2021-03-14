package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AccountRepository {

	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}


	public List<Account> getAllAccounts() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAccount(Account account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(account);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public Account getAccountByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Account account = session.get(Account.class, id);

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}


	public Account getAccountByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE username = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Account account=query.uniqueResult();

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}


	public void updateAccount(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// update
			department.setName(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAccount(Account account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(account);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteAccount(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Account account = (Account) session.load(Account.class, id);

			// delete
			session.delete(account);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAccountExistsByID(short id) {

		// get department
		Account account = getAccountByID(id);

		// return result
		if (account == null) {
			return false;
		}

		return true;
	}

	public boolean isAccountExistsByName(String name) {
		Account account = getAccountByName(name);

		if (account == null) {
			return false;
		}
		return true;
	}

	public Account getAccountByEmail(String email) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE email = :emailParameter");

			// set parameter
			query.setParameter("emailParameter", email);

			// get result
			Account account = query.uniqueResult();

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAccountExistsByEmail(String email) {

		// get account
		Account account = getAccountByEmail(email);

		// return result
		if (account == null) {
			return false;
		}

		return true;
	}
}
