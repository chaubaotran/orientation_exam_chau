package com.greenfox.licenseplates.repository;

import java.util.List;

import com.greenfox.licenseplates.model.LicensePlate;

public interface CustomLicensePlateRepository {
	public List<LicensePlate> filter(String q);
	public List<LicensePlate> getPoliceCars();
	public List<LicensePlate> getDiplomatCars();

}
