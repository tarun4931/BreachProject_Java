package com.src.breacherapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.breacherapp.model.Category;
import com.src.breacherapp.services.CategoryService;

@RestController
@RequestMapping("/getCategory")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/breach_categories")
	public List<Category> loginLoader(Long id) {
		return categoryService.getCatsByBusinessId( id);
	}
}
