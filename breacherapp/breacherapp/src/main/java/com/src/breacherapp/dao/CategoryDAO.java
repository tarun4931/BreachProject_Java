package com.src.breacherapp.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.src.breacherapp.model.Category;

@Component
public interface CategoryDAO {
	public List<Category> getAll();
	
	public List<Category> getCatsByBusinessId(Long Id);
}
