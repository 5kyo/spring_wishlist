package com.example.demo.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import java.util.stream.Collectors;

import com.example.demo.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails{

    private Long userId;
    private String userName;
    private String userEmail;

    @JsonIgnore
    private String userPassword;

    private Collection<? extends GrantedAuthority> authorities;
    public UserDetailsImpl( Long userId, 
                            String userName, 
                            String userEmail, 
                            String userPassword,
                            Collection<? extends GrantedAuthority> authorities){
                            
                            this.userId = userId;
                            this.userName = userName;
                            this.userEmail = userEmail;
                            this.authorities = authorities;
                            }

    public static UserDetailsImpl build(User user){
        List<GrantedAuthority> authorities = user.getRoles()
                                            .stream()
                                            .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                                            .collect(Collectors.toList());
        return new UserDetailsImpl( user.getUserId(), 
                                    user.getUserName(), 
                                    user.getUserEmail(), 
                                    user.getUserPassword(), 
                                    authorities);
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getUserId() {
		return userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

    @Override
	public String getPassword() {
		return userPassword;
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
    
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(userId, user.userId);
	}

}
