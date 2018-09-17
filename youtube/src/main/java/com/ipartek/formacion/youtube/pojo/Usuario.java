package com.ipartek.formacion.youtube.pojo;

public class Usuario {

	private String user;
	private String password;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [User=" + user + ", Password=" + password + "]";
	}
	
}
