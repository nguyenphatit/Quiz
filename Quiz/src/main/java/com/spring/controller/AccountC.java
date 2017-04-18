package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountC {
	@RequestMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/forgot_pass")
	public String forgotPassPage() {
		return "forgot_password";
	}

	@RequestMapping(value = "/change_pass")
	public String changePassPage() {
		return "change_password";
	}
}
