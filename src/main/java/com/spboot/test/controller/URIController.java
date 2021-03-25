package com.spboot.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class URIController {

	@GetMapping("/")
	public String hello() {		
		return "views/index";
	}
	
	@GetMapping("/views/**")
	public void goView() {
		
	}
}
