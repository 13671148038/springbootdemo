package com.example.demo.controller;

import com.example.autoconfigure.MyTestAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class WebController {

	@Autowired
	MyTestAutoConfiguration myTestAutoConfiguration;

	@GetMapping("/greeting")
	public String toIndex(Model model, HttpServletRequest request){
        String remoteUser = request.getContextPath();
        model.addAttribute("name", remoteUser);
		return "greeting";
	}

	@GetMapping("/getAutoConfiguration")
	public String getAutoConfiguration(){

		return "greeting";
	}
}
