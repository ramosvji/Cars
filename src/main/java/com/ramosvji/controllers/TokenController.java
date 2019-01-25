package com.ramosvji.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramosvji.model.JwtUser;
import com.ramosvji.model.Login;
import com.ramosvji.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {
private JwtGenerator jwtGenerator;
	
	public TokenController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}
	
	@PostMapping
	public ResponseEntity<?> generate(@RequestBody final Login login) {
		JwtUser jwtUser = new JwtUser();
		jwtUser = existUser(login);
		if(jwtUser != null) {
			List<String> lista = new ArrayList<>();
			lista.add(jwtGenerator.generate(jwtUser));
			return new ResponseEntity<List<String>>(lista, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	private JwtUser existUser(Login login) {
		if(login.getUser().equals("ignacio") && login.getPassword().equals("1234")) {
			JwtUser jwtUser = new JwtUser();
			jwtUser.setName(login.getUser());
			jwtUser.setId(1);
			jwtUser.setRole("Admin");
			return jwtUser;
			
		}else {
			return null;
		}
	}
}
