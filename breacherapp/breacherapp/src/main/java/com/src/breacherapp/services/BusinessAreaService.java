package com.src.breacherapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.src.breacherapp.dao.FranchiseDAO;
import com.src.breacherapp.model.BusinessArea;

@Component
public class BusinessAreaService {
	@Autowired
	FranchiseDAO franchDAO;

	public List<BusinessArea> getBusinessByFranchiseId(Long id) {
		return franchDAO.getAll().stream().filter(c->c.getId().equals(id)).findFirst().get().getBusArea();
	}
}
