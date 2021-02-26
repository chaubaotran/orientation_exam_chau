package com.greenfox.licenseplates.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenfox.licenseplates.model.SearchRecord;
import com.greenfox.licenseplates.service.LicensePlateService;
import com.greenfox.licenseplates.service.SearchRecordService;

@Controller
@RequestMapping("/search")
public class LicensePlateController {

	@Autowired
	LicensePlateService licensePlateService;

	@Autowired
	SearchRecordService searchRecordService;

	@GetMapping("")
	public String showAllPlates(@RequestParam(required = false) String q,
			@RequestParam(required = false) Integer police, @RequestParam(required = false) Integer diplomat,
			Model model) {
		Optional<String> qOpt = Optional.ofNullable(q);
		Optional<Integer> policeOpt = Optional.ofNullable(police);
		Optional<Integer> diplomatOpt = Optional.ofNullable(diplomat);

		

		if (!policeOpt.isEmpty()) {
			model.addAttribute("licensePlates", licensePlateService.getPoliceCars());
			return "index";
		}

		if (diplomatOpt.isPresent()) {
			model.addAttribute("licensePlates", licensePlateService.getDiplomatCars());
			return "index";
		}

		if (qOpt.isPresent()) {
			if (validateQuery(q)) {
				SearchRecord record = new SearchRecord();
				record.setQuery(q);
				searchRecordService.save(record);
				
				model.addAttribute("licensePlates", licensePlateService.filter(q));
			} else {
				model.addAttribute("error", "Sorry, the submitted license plate is not valid");
				model.addAttribute("licensePlates", null);
			}

		}
		return "index";
	}

	@GetMapping("/{brand}")
	public String showPlatesByBrand(@PathVariable String brand, Model model) {

		SearchRecord record = new SearchRecord();
		record.setBrand(brand);
		searchRecordService.save(record);

		model.addAttribute("licensePlates", licensePlateService.filter(brand));
		return "index";
	}

	public boolean validateQuery(String q) {
		boolean result = true;
		List<String> characters = Arrays.asList(q.split(""));
		
		if(characters.size() > 7) {
			return false;
		}
		
		List<String> allowedCharacters = Arrays.asList("-", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
				"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g",
				"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "0", "");

		for (String c : characters) {
			if (!allowedCharacters.contains(c)) {
				result = false;
				break;
			}
		}

		return result;

	}

}
