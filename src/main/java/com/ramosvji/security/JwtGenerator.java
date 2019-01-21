package com.ramosvji.security;

import org.springframework.stereotype.Component;

import com.ramosvji.constants.Constants;
import com.ramosvji.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*
 * Genera el JWT
 */
@Component
public class JwtGenerator {
	
	public String generate(JwtUser jwtUser) {
		Claims claims = Jwts.claims()
			.setSubject(jwtUser.getName());
		
		claims.put(Constants.USER_ID, String.valueOf(jwtUser.getId()));
		claims.put(Constants.ROLE, String.valueOf(jwtUser.getRole()));
		
		return Jwts.builder()
				.setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, Constants.SECRET)
				.compact();
	}

}
