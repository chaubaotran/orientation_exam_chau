package com.greenfox.licenseplates.service;

import java.util.List;

import com.greenfox.licenseplates.model.LicensePlate;

public interface LicensePlateService {

	public List<LicensePlate> findAll();
	
	public List<LicensePlate> filter(String q);
	
	public List<LicensePlate> getPoliceCars();
	public List<LicensePlate> getDiplomatCars();

}
