package com.bugo.aplikasidatadesa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/ok")
	public String hallo() {
		
		return "this is ok";
	}

}
