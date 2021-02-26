package com.greenfox.licenseplates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.greenfox.licenseplates.service.LicensePlateService;

@Controller
public class MainController {
	
	@Autowired
	LicensePlateService  licensePlateService;
	
	@GetMapping("/")
	public String showIndexPage(Model model) {
		model.addAttribute("licensePlates", licensePlateService.findAll());
		return "index";
	}

}
