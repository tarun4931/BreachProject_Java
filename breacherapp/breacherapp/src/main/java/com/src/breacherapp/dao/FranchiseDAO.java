package com.src.breacherapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.src.breacherapp.model.Franchise;

@Component
public interface FranchiseDAO {
	public List<Franchise> getAll();
}
