package com.src.breacherapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloworld")
public class DefaultController {
	@GetMapping("")
	public String loginLoader() {
		return "Hello World";
	}	
}
