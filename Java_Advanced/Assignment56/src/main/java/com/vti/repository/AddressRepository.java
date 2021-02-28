package com.vti.repository;

import com.vti.entity.Address;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AddressRepository {

	private HibernateUtils hibernateUtils;

	public AddressRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Address> getAllAddresses() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Address> query = session.createQuery("FROM Address");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Address getAddressByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Address address = session.get(Address.class, id);

			return address;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAddress(Address address) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(address);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public Address getAddressByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Address> query = session.createQuery("FROM Address WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Address address = query.uniqueResult();

			return address;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public void updateAddress(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Address address = (Address) session.load(Address.class, id);

			// update
			address.setName(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAddress(Address address) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(address);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteAddress(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Address address = (Address) session.load(Address.class, id);

			// delete
			session.delete(address);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAddressExistsByID(short id) {

		// get department
		Address Address = getAddressByID(id);

		// return result
		if (Address == null) {
			return false;
		}

		return true;
	}

	public boolean isAddressExistsByName(String name) {
		Address Address = getAddressByName(name);

		if (Address == null) {
			return false;
		}
		return true;
	}

}
