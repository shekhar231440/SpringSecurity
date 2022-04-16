package com.shekhar.security.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicController {
	
	@GetMapping("/message")
	public String getWelcomeMessage() {
		
		return "Hi... its a basic message";
	}
	
	@DeleteMapping("/delete")
	public String deleteMessage() {
		
		return "Basic message deleted...";
	}

}
