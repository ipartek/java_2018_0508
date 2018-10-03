package com.ipartek.formacion.youtube.pojo;

public class Usuario {
	
	private long id;
	private String nombre;
	private String pass;
	private int rol; //todo crear pojo y tabla
	
	public static final int ROL_ADMIN = 0;
	public static final int ROL_USER = 1;
	
	public Usuario() {
		super();
		this.id=-1;
		this.nombre = "";
		this.pass = "";
		this.rol = ROL_USER;
	}

		
	public Usuario(String nombre, String pass) {
		this();
		
		this.nombre = nombre;
		this.pass = pass;
	}
	
	public Usuario(long id, String nombre, String pass,int rol) {
		this();
		this.id=id;
		this.nombre = nombre;
		this.pass = pass;
		this.rol=rol;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId(){
		return this.id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public int getRol() {
		return this.rol;
	}
	
	public void setRol(int rol) {
		this.rol= rol;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", pass=" + pass + "]";
	}
	
}
