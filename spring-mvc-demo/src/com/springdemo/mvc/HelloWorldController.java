package com.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") //parent mapping
public class HelloWorldController {
	
	//need a controller method to show the initial form
	
	@RequestMapping("/showForm")//sub mapping(relative)
	public String showForm() {
		return "helloworld-form";
	}
	
	//need a controller method to process the HTML form
	
	@RequestMapping("/processForm")//sub mapping(relative)
	public String processForm() {
		return "helloworld";
	}
	
	
	//Create a new controller method to read form data and
	//add data to model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request , Model model) {
		
		//read the request parameter from the HTML form
		String theName = request.getParameter("studentName");
		
		//convert the all data to caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Yo! " + theName;
		
		//add message to the model
		model.addAttribute("message", result);
				
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName , Model model) {
		
		//read the request parameter from the HTML form
		//String theName = request.getParameter("studentName");
		//for above two line spring will do for us,Since we are using @RequestParam
		
		//convert the all data to caps
		theName = theName.toUpperCase();
		
		// create the message
		String result = "Hey my friend from v3!! " + theName;
		
		//add message to the model
		model.addAttribute("message", result);
				
		
		return "helloworld";
	}

	
	
}
