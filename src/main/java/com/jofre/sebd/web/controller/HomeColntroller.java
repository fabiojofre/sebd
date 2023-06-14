package com.jofre.sebd.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeColntroller {

	@GetMapping("/")
	public String home(){
		return "/home";
		
	}
}
