package com.jiang.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showHomePage() {
		return "main_menu";
	}
	
	@RequestMapping("/name_form")
	public String showNameForm() {
		return "name_form";
	}
	
	@RequestMapping("/process_form")
	public String processForm(HttpServletRequest request, Model model) {
		String user_name = request.getParameter("user_name");
		String user_name_upper = user_name.toUpperCase();
		model.addAttribute("user_name_upper", user_name_upper);
		return "result";
	}

}
