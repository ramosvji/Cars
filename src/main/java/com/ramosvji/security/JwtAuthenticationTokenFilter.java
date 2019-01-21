package com.ramosvji.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.ramosvji.constants.Constants;
import com.ramosvji.model.JwtAuthenticationToken;


/*
 * Se crea un filto para los JWT.
 */
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{
	
	private final static int INDEX = 7;

	protected JwtAuthenticationTokenFilter() {
		super("/ramosvji/api/**");	
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		String header = request.getHeader(Constants.AUTHORIZATION_HEADER);
		
		if(header == null || !header.startsWith(Constants.BEARED_TOKEN)) {
			throw new RuntimeException("Token invalido");
		}
		
		String authenticationToken = header.substring(INDEX);
		JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(authenticationToken);
		
		return getAuthenticationManager().authenticate(jwtAuthenticationToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);;
	}
	
	

}
