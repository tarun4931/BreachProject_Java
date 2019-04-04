package com.src.breacherapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.src.breacherapp.model.BusinessArea;
import com.src.breacherapp.model.Franchise;

@Component
public class BusinessAreaDAOImpl implements BusinessAreaDAO {

	@Autowired
	SessionFactory sessionFactory;

	public List<BusinessArea> getAll() {
		Session session = this.sessionFactory.openSession();
		List<BusinessArea> result = session.createQuery("from BusinessArea").list();
		session.close();
		return result;
	}
}
