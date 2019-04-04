package com.src.breacherapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.breacherapp.model.BusinessArea;
import com.src.breacherapp.services.BusinessAreaService;

@RestController
@RequestMapping("/business_area")
public class BusinessAreaController {
	
	@Autowired
	BusinessAreaService busService;
	
	@GetMapping("/{franchise_id}")
	public List<BusinessArea> getBusinessArea(@PathVariable("franchise_id") Long id) {
		return busService.getBusinessByFranchiseId(id);
	}
}
