package com.green.car.wash.company.customer.models;

public class AuthenticationRequest {
private String username;
private String password;
private String role;
private String email;
public AuthenticationRequest() {


}

public AuthenticationRequest(String username, String password, String role, String email) {
	super();
	this.username = username;
	this.password = password;
	this.role = role;
	this.email = email;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "AuthenticationRequest [username=" + username + ", password=" + password + ", role=" + role + ", email="
			+ email + "]";
}




}
