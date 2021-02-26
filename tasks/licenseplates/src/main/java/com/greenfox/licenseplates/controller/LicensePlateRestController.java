package com.greenfox.licenseplates.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greenfox.licenseplates.dto.LicensePlateDto;
import com.greenfox.licenseplates.dto.SearchRecordDto;
import com.greenfox.licenseplates.model.LicensePlate;
import com.greenfox.licenseplates.model.SearchRecord;
import com.greenfox.licenseplates.service.LicensePlateService;
import com.greenfox.licenseplates.service.SearchRecordService;

@RestController
@RequestMapping("/api")
public class LicensePlateRestController {
	
	@Autowired
	LicensePlateService licensePlateService;
	
	@Autowired
	SearchRecordService searchRecordService;
	
	@GetMapping("/search/{brand}")
	public LicensePlateDto showPlatesByBrand(@PathVariable String brand) {
		List<LicensePlate> plates = licensePlateService.filter(brand);
		LicensePlateDto licensePlateDto = new LicensePlateDto();
		licensePlateDto.setResult("ok");
		licensePlateDto.setData(plates);		
		return licensePlateDto;
	}

	@GetMapping("/search-history")
	public SearchRecordDto showSearchHistory() {
		List<SearchRecord> records = searchRecordService.findAll();
		SearchRecordDto searchRecordDto = new SearchRecordDto();
		searchRecordDto.setResult("ok");
		searchRecordDto.setData(records);		
		return searchRecordDto;
	}
}
