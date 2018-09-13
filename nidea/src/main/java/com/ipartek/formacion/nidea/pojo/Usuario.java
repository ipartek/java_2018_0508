package com.ipartek.formacion.nidea.pojo;

public class Usuario {
	
	private String nombre;
	private String mail;
	private String psw;
	
	//	CONSTRUCTOR(es)
	public Usuario() {
		super();
		this.nombre = "";
		this.mail = "";
		this.psw = "";
	}
	
	public Usuario(String nombre, String mail, String psw) {
		this();
		this.nombre = nombre;
		this.mail = mail;
		this.psw = psw;
	}
	
	// 	GETTERS AND SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre.trim();
	}
	public String getMail() {
		return mail.trim();
	}
	public void setMail(String mail) {
		this.mail = mail.trim();
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw.trim();
	}
	
	

}
