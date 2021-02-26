package com.greenfox.licenseplates.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.greenfox.licenseplates.model.SearchRecord;

@Repository
public interface SearchRecordRepository extends MongoRepository<SearchRecord, String>{

}
