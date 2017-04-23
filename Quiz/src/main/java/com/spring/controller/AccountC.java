package com.spring.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.google.common.collect.Lists;
import com.spring.service.AccountS;

import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;
import it.ozimov.springboot.mail.service.exception.CannotSendEmailException;

@Controller
@RequestMapping("/account")
@SessionAttributes("account")
public class AccountC {
	@Autowired
	private AccountS accountService;
	@Autowired
	private EmailService e;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage(Model model, WebRequest wr) {
		String email = wr.getParameter("email1");
		String password = wr.getParameter("pass1");
		if (!accountService.checkEmail(email)) {
			model.addAttribute("err", "Email không đúng");
			model.addAttribute("email", email);
			return "login_page";
		} else if (!accountService.checkEmailAndPassword(email, password)) {
			model.addAttribute("err", "Mật khẩu không đúng");
			model.addAttribute("email", email);
			return "login_page";
		}
		model.addAttribute("account", accountService.getAccountByEmail(email));
		return "redirect:/home";
	}

	@RequestMapping(value = "/forgot_pass")
	public String forgotPassPage() throws AddressException, CannotSendEmailException, UnsupportedEncodingException {
		   final Email email = DefaultEmail.builder()
			        .from(new InternetAddress("ttlang162@gmail.com", "lang"))
			        .to(Lists.newArrayList(new InternetAddress("lang.tt16@gmail.com", "lang")))
			        .subject("gửi mail")
			        .body("Test mail")
			        .encoding("UTF-8").build();

		   final Map<String, Object>modelObject=new HashMap<>();	
		   modelObject.put("h", "Xin chào");
			   e.send(email,"mail.html",modelObject);
		return "forgot_password";
	}

	@RequestMapping(value = "/change_pass")
	public String changePassPage() {

		return "change_password";
	}
}
