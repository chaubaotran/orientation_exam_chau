package com.greenfox.licenseplates.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.greenfox.licenseplates.model.LicensePlate;

public class CustomLicensePlateRepositoryImpl implements CustomLicensePlateRepository {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<LicensePlate> filter(String q) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<LicensePlate> theQuery = currentSession.createQuery("from LicensePlate where plate like :q or carBrand like :q or carModel like :q or color like :q or year like :q", LicensePlate.class);
		theQuery.setParameter("q", "%" + q + "%");

		List<LicensePlate> licensePlates;

		try {
			licensePlates = theQuery.getResultList();
		} catch (Exception e) {
			licensePlates = null;
		}
		return licensePlates;
	}

	@Override
	public List<LicensePlate> getPoliceCars() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<LicensePlate> theQuery = currentSession.createQuery("from LicensePlate where plate like 'RB%'", LicensePlate.class);

		List<LicensePlate> licensePlates;

		try {
			licensePlates = theQuery.getResultList();
		} catch (Exception e) {
			licensePlates = null;
		}
		return licensePlates;
	}

	@Override
	public List<LicensePlate> getDiplomatCars() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<LicensePlate> theQuery = currentSession.createQuery("from LicensePlate where plate like 'DT%'", LicensePlate.class);

		List<LicensePlate> licensePlates;

		try {
			licensePlates = theQuery.getResultList();
		} catch (Exception e) {
			licensePlates = null;
		}
		return licensePlates;
	}
	

}
