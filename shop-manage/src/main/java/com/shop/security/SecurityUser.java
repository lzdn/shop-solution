package com.shop.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shop.domain.admin.Role;
import com.shop.dto.admin.UserDTO;
 


public class SecurityUser extends UserDTO implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SecurityUser(UserDTO userDTO) {
		if (userDTO != null) {
			this.setUserId(userDTO.getUserId());
			this.setUsername(userDTO.getUsername());
			this.setPassword(userDTO.getPassword());
			this.setRole(userDTO.getRole());
			this.setModules(userDTO.getModules());
		}
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Role role = this.getRole();
		if (role != null) {
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
			authorities.add(authority);
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
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
