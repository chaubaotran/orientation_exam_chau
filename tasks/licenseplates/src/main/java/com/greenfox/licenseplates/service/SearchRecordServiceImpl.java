package com.greenfox.licenseplates.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenfox.licenseplates.model.SearchRecord;
import com.greenfox.licenseplates.repository.SearchRecordRepository;

@Service
public class SearchRecordServiceImpl implements SearchRecordService {

	@Autowired
	SearchRecordRepository searchRecordRepo;

	@Override
	public List<SearchRecord> findAll() {
		return searchRecordRepo.findAll();
	}

	@Override
	public void save(SearchRecord record) {
		searchRecordRepo.save(record);
	}

}
