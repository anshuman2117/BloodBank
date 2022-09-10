package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	public HomeController() {
		System.out.println("in ctor of " + getClass());
	}

	@GetMapping("/")
	public String showHomePage() {
		System.out.println("in home page");
		return "running first time project";
	}
}