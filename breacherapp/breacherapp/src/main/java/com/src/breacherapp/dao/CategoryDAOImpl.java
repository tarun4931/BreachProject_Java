package com.src.breacherapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.src.breacherapp.model.BusinessArea;
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

	public List<Category> getCatsByBusinessId(Long id) {
		Session session = this.sessionFactory.openSession();
		BusinessArea result = session.get(BusinessArea.class, id);
		session.close();
		return result == null ? new ArrayList() : result.getCategory();
	}
}
