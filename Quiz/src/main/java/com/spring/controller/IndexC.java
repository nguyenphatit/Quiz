package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexC {
	@RequestMapping(value="/")
	public String homePage(){
		return "login_page";
	}
}
