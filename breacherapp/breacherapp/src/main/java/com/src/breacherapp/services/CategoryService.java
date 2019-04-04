package com.src.breacherapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.src.breacherapp.dao.CategoryDAO;
import com.src.breacherapp.model.Category;

@Component
public class CategoryService {

	@Autowired
	CategoryDAO categoryDAO;
	
	public List<Category> getCatsByBusinessId(Long id) {
		return categoryDAO.getCatsByBusinessId(id);
	}	
}
