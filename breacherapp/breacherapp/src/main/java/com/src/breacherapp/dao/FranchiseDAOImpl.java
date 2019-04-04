package com.src.breacherapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.src.breacherapp.model.Franchise;

@Component
public class FranchiseDAOImpl implements FranchiseDAO {

	@Autowired
	SessionFactory sessionFactory;

	public List<Franchise> getAll() {
		Session session = this.sessionFactory.openSession();
		List<Franchise> result = session.createQuery("from Franchise").list();
		session.close();
		return result;

	}
}
