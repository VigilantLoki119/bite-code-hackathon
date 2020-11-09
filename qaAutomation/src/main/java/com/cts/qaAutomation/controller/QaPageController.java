package com.cts.qaAutomation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.qaAutomation.model.HomeFormData;

@Controller
public class QaPageController {

//	HomeFormData homeFormData = new HomeFormData();
	
	@RequestMapping("/")
	public String welcomePage() {
		return "home";
	}
	
	@GetMapping("/Home-form")
	public void homeForm(HomeFormData homeFormData) {
		
		System.out.println(homeFormData.getApplication1());
	
	}
}
