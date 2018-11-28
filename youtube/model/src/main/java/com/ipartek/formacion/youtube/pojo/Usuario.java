package com.ipartek.formacion.youtube.pojo;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Usuario {
	
	public static final int STATUS_ELIMINADO = 0;
	public static final int STATUS_ACTIVO = 1;
	
	private long id;

	@NotBlank
	@Size(max=50,min=2)
	private String alias;
	
	@NotBlank
	@Size(max=20,min=6)
	private String password;
	
	private Rol rol; // 1: Admin, 2: Usuario

	// CONSTRUCTORES
	public Usuario() {
		super();
		this.id = -1;
		this.password = "";
		this.rol = new Rol();
	}

	public Usuario(String alias, String password) {
		this();
		this.alias = alias;
		this.password = password;
	}

	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", alias=" + alias + ", password=" + password + ", rol=" + rol + "]";
	}

}
