package com.spring.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.spring.service.AccountS;

import it.ozimov.springboot.mail.service.exception.CannotSendEmailException;

@Controller
@RequestMapping("/account")
@SessionAttributes("account")
public class AccountC {
	@Autowired
	private AccountS accountService;

	//private Mail mail;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage(Model model, WebRequest wr) {
		String email = wr.getParameter("email");
		String password = wr.getParameter("password");
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

	@RequestMapping(value = "/forgot_pass", method = RequestMethod.GET)
	public String forgotPassPage(Model model, WebRequest wr)
			throws AddressException, CannotSendEmailException, UnsupportedEncodingException {
		String email = wr.getParameter("email");

		System.out.println(email);

		return "forgot_password";
	}

	@RequestMapping(value = "/change_pass")
	public String changePassPage() {

		return "change_password";
	}
	
	@RequestMapping(value="/sign_up")
	public String signUp(Model  model, WebRequest wr){
		//String email =wr.getParameter("email2");
		//String password =wr.getParameter("pass2");
		//String rePassword=wr.getParameter("re_pass");
		return "sign_up";
	}
}
