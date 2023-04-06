package com.cooley.springboot.soccerlineupapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		
		boolean isValidUsername = username.equalsIgnoreCase("Harrison");
		boolean isValidPassword = password.equalsIgnoreCase("password");
		
		return isValidUsername && isValidPassword;
	}

}
