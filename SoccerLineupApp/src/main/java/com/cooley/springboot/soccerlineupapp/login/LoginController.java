package com.cooley.springboot.soccerlineupapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name") //this will allow information in " "s put in the model to be used across multiple requests within same session
//Be careful to only store info needed across multiple requests because SessionAttrivutes uses more memory by storing on server
public class LoginController {

	
	//private Logger logger = LoggerFactory.getLogger(getClass());
	
	private AuthenticationService authenticationService;
	
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		//this.logger = logger;
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String loginView() {
		
		return "login";
			
	}
	
	//Use request param to capture form data
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if (authenticationService.authenticate(name, password)) {
			
			//Model is only available for the scope of that request.
			//Request scope: Active for single request
			
			model.put("name", name);
			//model.put("password", password);
			
			//redirects to the welcome page if it is a POST method. i.e when username and password are submitted
			return "welcome";
		}
		
		
		model.put("errorMessage", "Error - login invalid try again");
		return "login";
		
			
	}
	
//	//http://localhost:8080/login?name=Ranga
//	//Important concept: Use a model for data that your view is going to use
//	@RequestMapping("login")
//	public String loginView(@RequestParam String name, ModelMap model) {
//		
//		model.put("name", name);
//		
//		//Logging examples
//		//logger.debug("Request param is {}", name);
//		//logger.info("I want this to print at the info level");
//		//logger.warn("I want this to print at the warn level");
//		
//		//Not good practice to use sysout. Should use logging for PROD code, but this is just a small example
//		//System.out.println("Request param from sysout is " + name); 
//		
//		return "login";
//		
//	}
		
		
		//http://localhost:8080/login?name=Ranga
		//Important concept: Use a model for data that your view is going to use
//		@RequestMapping("login-custom")
//		public String loginViewCustom(@RequestParam String name, int age, ModelMap model) {
//			
//			model.put("name", name);
//			
//			model.put("age", age);
//			
//			String augName = "The king " + name;
//			
//			model.put("augName", augName);
//			
//			System.out.println("Request param is " + name); //Not good practice. Should use logging for PROD code, but this is just a small example
//			
//			return "loginCustom";
//	}
	
}
