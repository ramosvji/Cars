package com.ramosvji.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetail implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String token;
	private Long id;
	private Collection<? extends GrantedAuthority> authorities;

	public JwtUserDetail(String userName, String token, Long id, List<GrantedAuthority> authorities) {
		super();
		this.userName = userName;
		this.token = token;
		this.id = id;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
