package com.greenfox.licenseplates.service;

import java.util.List;

import com.greenfox.licenseplates.model.SearchRecord;

public interface SearchRecordService {
	
	public List<SearchRecord> findAll();
	public void save(SearchRecord record);

}
