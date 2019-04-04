package com.src.breacherapp.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.src.breacherapp.model.BusinessArea;

@Component
public interface BusinessAreaDAO {
	public List<BusinessArea> getAll();
}
