package com.ipartek.formacion.pojo;
/**
 * pojo (contructor, getters, setters y to String que se llame usuario 
 * y que va a tener un id que es un login y un password y email. 
 *Los atributos seran private
 * @author Curso
 *
 */

public class Usuario {
		
		private String usuario;
		private String email;
		private String password;
		private int id;
		
	public Usuario(){
		
		super();
		this.usuario="";
		this.email="";
		this.password="";
		this.id=1;
			
	}
	
	
	
	public String getUsuario() {
		return usuario;
	}




	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", email=" + email + ", password=" + password + ", id=" + id + "]";
	}



}
