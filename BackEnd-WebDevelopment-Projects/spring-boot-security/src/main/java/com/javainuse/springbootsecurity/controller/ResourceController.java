package com.javainuse.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	
	@GetMapping("/hellouser")
	public String getUser()
	{
		return "Hello User";
	}
	
	@GetMapping("/helloadmin")
	public String getAdmin()
	{
		return "Hello Admin";
	}

}
