package com.spboot.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.spboot.test.service.CustomerInfoService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class URIController {
	private static final List<String> excludeList = new ArrayList<>();
	private static final boolean isDev = true;
	
	@Autowired
	private CustomerInfoService cuiServ;
	static {
		excludeList.add("/views/file/file-info-list");
		excludeList.add("/views/food/food-info-list");
		excludeList.add("/views/user/login");
	}

	@GetMapping("/")
	public String hello() {		
		return "views/index";
	}
	
	@GetMapping("/views/**")
	public String goView(HttpServletRequest req) {
		String uri = req.getRequestURI();
		HttpSession hs = req.getSession();
		log.info(uri);
		if(hs.getAttribute("costumerInfo")==null) {
			if(isDev) {
				hs.setAttribute("customerInfo", cuiServ.getCustomerInfoById(1)); 
				return uri;
			}
			if(!excludeList.contains(uri)) {
				return "/views/user/msg";
			}
		}
		return uri;
		
	}
}
