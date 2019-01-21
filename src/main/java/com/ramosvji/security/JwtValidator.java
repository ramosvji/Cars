package com.ramosvji.security;

import org.springframework.stereotype.Component;

import com.ramosvji.constants.Constants;
import com.ramosvji.model.JwtUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/*
 * Extrae los datos que llegron
 */
@Component
public class JwtValidator {
	
	public JwtUser validate(String token) {
		JwtUser jwtUser = null;
		
		try {
			Claims body = Jwts.parser().setSigningKey(Constants.SECRET)
					.parseClaimsJws(token)
					.getBody();
			
			jwtUser = new JwtUser();
			jwtUser.setName(body.getSubject());
			jwtUser.setId(Long.parseLong((String) body.get(Constants.USER_ID)));
			jwtUser.setRole((String) body.get(Constants.ROLE));
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return jwtUser;
	}

}
