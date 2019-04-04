package com.src.breacherapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Franchise implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private String name;
	
	@OneToMany
	@JoinColumn(name="franch_busarea")
	private List<BusinessArea> busArea;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BusinessArea> getBusArea() {
		return busArea;
	}
	public void setBusArea(List<BusinessArea> busArea) {
		this.busArea = busArea;
	}
}
