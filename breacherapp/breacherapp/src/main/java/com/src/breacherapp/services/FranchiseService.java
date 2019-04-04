package com.src.breacherapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.src.breacherapp.dao.FranchiseDAO;
import com.src.breacherapp.model.Franchise;

@Component
public class FranchiseService {

	@Autowired
	FranchiseDAO franchDAO;
	
	public List<Franchise> getAll() {
		return franchDAO.getAll();
	}	
}
