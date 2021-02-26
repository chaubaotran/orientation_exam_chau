package com.greenfox.licenseplates.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greenfox.licenseplates.model.LicensePlate;

@Repository
public interface LicensePlateRepository extends CrudRepository<LicensePlate, Long>,  CustomLicensePlateRepository {
		
}
