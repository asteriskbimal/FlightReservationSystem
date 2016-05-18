package com.flight.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class SystemUser {

	@Id
	@GeneratedValue
	long usedId;
	
	private String userName;
	
	private String password;
	
	private boolean enabled;
	
    @Enumerated(EnumType.STRING)
	private Role role;

	public long getUsedId() {
		return usedId;
	}

	public void setUsedId(long usedId) {
		this.usedId = usedId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
