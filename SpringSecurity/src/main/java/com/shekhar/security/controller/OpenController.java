package com.shekhar.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/open")
public class OpenController {
	
	@GetMapping("/message")
	public String getOpenMessage() {
		
		return "It is an open message";
	}

}
