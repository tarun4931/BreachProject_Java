package com.src.breacherapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.src.breacherapp.model.Category;

@Component
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	public List<Category> getAll() {
		Session session = this.sessionFactory.openSession();
		List<Category> result = session.createQuery("from Category").list();
		session.close();
		return result;

	}
}
