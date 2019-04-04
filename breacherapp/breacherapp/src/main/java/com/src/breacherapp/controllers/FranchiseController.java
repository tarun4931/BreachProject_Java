package com.src.breacherapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.breacherapp.model.Franchise;
import com.src.breacherapp.services.FranchiseService;

@RestController
@RequestMapping("/getFranchise")
public class FranchiseController {
	
	@Autowired
	FranchiseService franchService;
	
	@GetMapping("")
	public List<Franchise> loginLoader() {
		return franchService.getAll();
	}
}
