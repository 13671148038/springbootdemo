package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class WebController {

	@GetMapping("/greeting")
	public String toIndex(Model model, HttpServletRequest request){
        String remoteUser = request.getContextPath();
        model.addAttribute("name", remoteUser);
		return "greeting";
	}
}
