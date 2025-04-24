package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class LoginController {
	LoginService loginServ;
	
	public LoginController(LoginService loginService) {
		// TODO Auto-generated constructor stub
		this.loginServ = loginService;
	}
	
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Map<String, String> request, HttpServletResponse finalResponse) {
		try {
			String username = request.get("username");
			String password = request.get("password");
			
			boolean validated = loginServ.validateUser(username, password);
			if(validated) {
				Map<String, String> servResponse = new HashMap<>();
				servResponse.put("username", username);
				servResponse.put("message", "Success");
				finalResponse.setStatus(HttpServletResponse.SC_OK);
				return servResponse;
			} else {
				Map<String, String> response = new HashMap<>();
				response.put("ERROR", "Login Failed. Please Enter Valid Credentials");
				finalResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return response;
			}
			
		} catch (Exception e) {
			Map<String, String> resoponse = new HashMap<>();
			resoponse.put("ERROR", e.getMessage());
			finalResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return resoponse;
		}
	}
}
