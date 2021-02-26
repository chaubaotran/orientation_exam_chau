package com.greenfox.licenseplates.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenfox.licenseplates.model.LicensePlate;
import com.greenfox.licenseplates.repository.LicensePlateRepository;

@Service
public class LicensePlateServiceImpl implements LicensePlateService {
	
	@Autowired
	LicensePlateRepository licensePlateRepo;
	

	@Override
	public List<LicensePlate> findAll() {
		return (List<LicensePlate>) licensePlateRepo.findAll();
	}

	@Override
	public List<LicensePlate> filter(String q) {
		return licensePlateRepo.filter(q);
	}

	@Override
	public List<LicensePlate> getPoliceCars() {
		return licensePlateRepo.getPoliceCars();
	}

	@Override
	public List<LicensePlate> getDiplomatCars() {
		return licensePlateRepo.getDiplomatCars();
	}

}
