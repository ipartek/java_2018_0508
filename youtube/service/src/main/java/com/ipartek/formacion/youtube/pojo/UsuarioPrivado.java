package com.ipartek.formacion.youtube.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class UsuarioPrivado extends Usuario {
	private long id;

	@NotBlank
	@Size(min = 2, max = 20)
	private String pass;
	private Rol rol;

	public UsuarioPrivado() {
		super();
		this.pass = "";
		this.rol = new Rol();

	}

	public UsuarioPrivado(String nombre, String pass) {
		this();
		setNombre(nombre);
		setPass(pass);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "UsuarioPrivado [id=" + id + ", pass=" + pass + ", rol=" + rol + "]";
	}

	

}
