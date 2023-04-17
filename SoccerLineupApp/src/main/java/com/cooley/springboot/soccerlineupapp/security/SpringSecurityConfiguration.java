package com.cooley.springboot.soccerlineupapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
	//This function uses the built in spring security to create user profiles in spring security
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		
		
		UserDetails userDetails = createNewUser("Harrison", "password");
		UserDetails userDetails2 = createNewUser("User", "password");
		
		
		return new InMemoryUserDetailsManager(userDetails, userDetails2);
	}

	//This function creates objects that spring security uses to store profile information based on username and password input
	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passWordEncoder = input -> passwordEncoder().encode(input);
		
		
		UserDetails userDetails = User.builder()
				.passwordEncoder(passWordEncoder)
				.username(username)
				.password(password)
				.roles("USER", "ADMIN")
				.build();
		return userDetails;
	}
	
	//This function makes a password encoding for the UserDetail object that spring security uses
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
