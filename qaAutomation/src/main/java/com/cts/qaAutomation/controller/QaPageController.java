package com.cts.qaAutomation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QaPageController {

	@RequestMapping("/")
	public String welcomePage() {
		return "index";
	}
}
